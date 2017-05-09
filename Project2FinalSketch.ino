#include <ANN_EEPROM.h>
#include "MeMCore.h"
MeDCMotor motor1(M1);
MeDCMotor motor2(M2);
Me7SegmentDisplay disp(PORT_1);
MeLineFollower lineFinder(PORT_2);
Me4Button btn(PORT_8);
/*
 * Set variables for sketch
 */

#define TWO_SENSOR //Comment out to use one line sensor

#ifdef TWO_SENSOR
uint16_t patterns[] = {58, 5, 22, 41};
#else
uint16_t patterns[] = {1, 6};
#endif


//Create 2 states for learn and moving
#define LEARN 1
#define MOVE 2



int current;
int previousSensorState;
int cycles;
boolean check;

float learningRate = 0.6;
float momentum = 0.9;


void setup() {

  check = false;
  cycles = 0;


#ifdef TWO_SENSOR
  inputNodes = 2;
  hiddenNodes = 4;
  outputNodes = 4;
  patternCount = 4;
#else
  inputNodes = 1;
  hiddenNodes = 4;
  outputNodes = 2;
  patternCount = 2;
#endif
  targetSuccess = 0.0004;



  // Open serial connection
  Serial.begin(115200);
  while (!Serial) {}

  createArrays();

  Serial.print("\nWriting data to EEPROM...");

  createWeights(0.5);

  writeToEEPROM(patterns);



  Serial.println("DONE!");
  int addresstest = 0;
  readEEPROM (&addresstest);


}

void loop() {

  /*
    //Switches between each
    int buttonOn = analogRead(A7);
    disp.display(cycles);
    //Need to call rotate state once
    //then send it to loop



    if (buttonOn == 0) {
    switch (current) {
      case LEARN:
        learnState();
        break;
      case MOVE:
        moveState();
        break;
      case ROTATE:
        rotateState();
    }
    }

  */

  //learnState();

  /*
   * Used to check if button is on
   * If it is start the program and run states
   * and display cycles
   */
  int buttonOn = analogRead(A7);
  if (buttonOn == LOW) {
    check = true;
    current = LEARN;
  }

  if (check) {
    disp.display(cycles);

    if (current == LEARN) {
      motor1.run(100);
      motor2.run(100);
      learnState();
    } else if (current == MOVE) {
      moveState();
    }



  }
}

void learnState() {
#ifdef TWO_SENSOR
  int curSensorState = lineFinder.readSensors();// get input
  if (curSensorState != previousSensorState) { //check if it was same as before if not go to function
    switch (curSensorState) {
      //IN, IN = 0
      //IN, OUT = 1
      //OUT, OUT = 2
      //OUT, IN = 3
      case S1_IN_S2_IN:
        //curSuccess = trainOnce(0, learningRate, momentum);
        if (trainOnce(0, learningRate, momentum) > targetSuccess) { //check if it finally hit targetSuccess
          //code for comparison
          //Add 1 to cycle for time
          cycles++;
          //Get previous to be current for next comparison
          previousSensorState = curSensorState;
          //Now make it rotate

          //rotateState();
        }
        else {
          current = MOVE; //switch to move state
        }




        break;






      case S1_IN_S2_OUT:
        //curSuccess = (trainOnce(1, learningRate, momentum);
        if (trainOnce(1, learningRate, momentum) > targetSuccess) { //check if finally hit targetSuccess
          //code for comparison
          //Add 1 to cycle for time
          cycles++;
          //Get previous to be current for next comparison
          previousSensorState = curSensorState;
          //Now make it rotate
          //rotateState();
        }
        else {
          current = MOVE; //switch to move state
        }


        break;

      case S1_OUT_S2_IN:
        //curSuccess = (trainOnce(3, learningRate, momentum);
        if (trainOnce(3, learningRate, momentum) > targetSuccess) { //Check if it finally hit target Success
          //code for comparison
          //Add 1 to cycle for time
          cycles++;
          //Get previous to be current for next comparison
          previousSensorState = curSensorState;
          //Now make it rotate
          //rotateState(); // Goes to rotate need to tell it to go back to learn
        }
        else {
          current = MOVE; //switch to move state
        }

        break;

      case S1_OUT_S2_OUT:
        
        //curSuccess = (trainOnce(2, learningRate, momentum);
        if (trainOnce(2, learningRate, momentum) > targetSuccess) { //Check if it finally hit target Success
          //code for comparison
          //Add 1 to cycle for time
          cycles++;
          //Get previous to be current for next comparison
          previousSensorState = curSensorState;
          //Now make it rotate
          //rotateState();
        }

        else {
          current = MOVE; //switch to move state
        }


        break;







    }

  }
#else


  //Onesensor part
  //Get currentSensor
  boolean curSensorState = lineFinder.readSensor1(); //read one line sensor
  if(curSensorState != previousSensorState){ //check if it was same as previous if not go to switch
    switch(curSensorState){
      case true: //If true
      if(trainOnce(1, learningRate, momentum) > targetSuccess){ //Check if it finally got to tar success
        //Add one to cycle
        cycles++;
        //change previous to current so it can learn again
        previousSensorState = curSensorState;
        
        
      }
      else{
        current = MOVE; //switch to move if it target success
      }
      break;

      case false: //If off the line
      if(trainOnce(0, learningRate, momentum) > targetSuccess){ //Check if it finally got to target success
        cycles++; //Add one to cycle
        //Change it back to previous so it can learn again
        previousSensorState = curSensorState;
        
      }
      else{
        current = MOVE; //switch back to move
        
      }
      break;
    }
    
  }

#endif

}
/*

  void rotateState() {
  motor1.run(100);
  motor2.run(100);
  current = LEARN;
  }
*/


void moveState() {
  /* Use evaluate function
      Create an array of inputs
      Create an array of outputs
      Check which sensor is on after passing input and output with evaluate
      If on inp =  1 if off inp = 0
      Make inputs that evaluate

  */
#ifdef TWO_SENSOR

  uint8_t input[inputNodes]; //Read in Input array
  float output[outputNodes]; //Read in Output array

  int curSensorState = lineFinder.readSensors(); //read two line sensor inputs
  switch (curSensorState) {


    case S1_IN_S2_IN: // 1 means in and sensor is on. 0 means out and sensor is not on
      input[0] = 1; //both on so both 1
      input[1] = 1;
      evaluate(input, output); //call evaluate so it can go to output array
      break;

    case S1_IN_S2_OUT: //first in second out
      input[0] = 1; 
      input[1] = 0;
      evaluate(input, output); //call evaluate so it can go to output array
      break;

    case S1_OUT_S2_IN: //first 0 second 1
      input[0] = 0;
      input[1] = 1;
      evaluate(input, output); //To output array
      break;

    case S1_OUT_S2_OUT: // both 0
      input[0] = 0;
      input[1] = 0;
      evaluate(input, output); //To output array
      break;
  }

  //Moving part
  //Sensor is broken into four, 0 1 for the first and 2,3 for the second.
  //Only one that matters is first in both
  //If they are over .5 they are on if not they are off because of float.
  //Use this to tell which is which
  if (output[0] > 0.5 && output[2] > 0.5) { //For first case
    Serial.println("Sesnor 1 and 2 are inside of black line");
    motor1.run(-100);
    motor2.run(100);

  }

  else if (output[0] > 0.5 && output[2] <= 0.5) { // for second case S1_IN, S2_OUT
    motor2.run(100);
    motor1.stop(); // Maybe take this out

  }

  else if (output[0] <= 0.5 && output[2] > 0.5) { //For third case S1_OUT_S2_IN
    Serial.println("Sensor 2 is inside the black line");
    motor2.stop();
    motor1.run(-100);
  }

  else if (output[0] <= 0.5 && output[2] <= 0.5) {
    //Make it go backwards need to figure this out
    motor1.run(100);
    motor2.run(-100);

  }

#else

  uint8_t input[inputNodes]; //get input array
  float output[outputNodes]; //get output array

  boolean curSensorState = lineFinder.readSensor1(); //read one line sensor
  switch (curSensorState){ //check current state
    case true: //If true
    input[0] = 1; //input 1
    evaluate(input, output); //convert to output array
    break;

    case false: // if fals
    input[0] = 0; //input = 0
    evaluate(input, output); //convert to output array
    break;
  }

  /*Left or Right
   * 
   */

  if(output[0] > .5){ //if true do this movement
    motor1.run(-100);
    motor2.stop();
  }
  else if(output[0] <= .5){ //if false do this movement
    motor1.stop();
    motor2.run(100);
  }


#endif


}

