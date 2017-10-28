'''
Created on Oct 15, 2017

@author: Alex Levin
CSC32501_SER32501_17FA: CSC32501_SER32501_17FA Database Systems (SER 325)
Python Project 1, BMI
'''
from pip._vendor.distlib.compat import raw_input
from math import sqrt
import pylab

def main():

    ##get the lines
    lines = get_lines("body.dat.txt")
    personsFormula = []
    personsBMI = []
    personsWeight = []
    personsAge = []
    ##NOW FULLY POPULATE Peoples BMI
    for line in lines:
        chestDiam = get_chestDiameter(line)
        chestDepth = get_chestDepth(line)
        bCDiameter = get_bCDiameter(line)
        ankleGirth = get_AnkleGirth(line)
        wristGirth = get_WristGirth(line)
        height = get_height(line)
        weight = get_weight(line)
        ##Put in Arrays
        personsFormula.append(formula(chestDiam, chestDepth, bCDiameter, wristGirth, ankleGirth, height))
        personsBMI.append(calculate_bmi(weight, height))
        personsAge.append(get_age(line))
        personsWeight.append(get_weight(line))
    
    
    ## Print Slope and Intercept
    ##BMI
    bmiSlope = slope(personsAge, personsBMI)
    bmiIntercept = intercept(personsAge, personsBMI)
    
    print ("Slope and Intercept for Age and BMI is: " + str(round(bmiSlope,3)) + ", " + str(round(bmiIntercept, 3)))
    correlation(personsAge, personsBMI)
    ##Physical Attributes
    formulaSlope = slope(personsWeight, personsFormula)
    formulaIntercept = intercept(personsWeight, personsFormula)
    
    print("Slope and Intercept for Weight and Formula is: " + str(round(formulaSlope, 3)) + ", " + str(round(formulaIntercept, 3)))
    correlation(personsWeight, personsFormula)
    
    ##Plot the lines
    ##BMI GRAPH
    pylab.plot(personsAge, personsBMI, 'ro')
    pylab.xlabel("Age")
    pylab.ylabel("BMI")
    ## y = m * x + b
    yp = [((bmiSlope * i) + bmiIntercept) for i in personsAge]
    pylab.plot(personsAge, yp)
    pylab.show()
    
    ##FORMULA GRAPH
    pylab.plot(personsWeight, personsFormula, 'bo')
    pylab.xlabel("Weight(kg)")
    pylab.ylabel("Formula Results")
    ##y = m * x + b
    yp = [((formulaSlope * i) + formulaIntercept) for i in personsWeight]
    pylab.plot(personsWeight, yp, 'r')
    pylab.show()
    
    
def get_lines(my_file):
    with open(my_file) as f:
        content = f.readlines()
    ##Create dictionary instead maybe
    content = [x.rstrip('\n') for x in content]
    return content
        
##Get column of specific thing that pertains to the line
##To a specific line
def get_column(lines, number):
    line = lines.split()
    column = line[number]
    return column

##how much data you want from the loop variable
def get_chestDiameter(lines):
    chest_diameter = get_column(lines,  4)
    return chest_diameter

def get_chestDepth(lines):
    chest_depth = get_column(lines,  3)
    return chest_depth

##bitrochantericDiameter 
def get_bCDiameter(lines):
    bitrochantericDiameter = get_column(lines,  2)
    return bitrochantericDiameter 

def get_WristGirth(lines):
    wristGirth = get_column(lines, 20)
    return wristGirth

def get_AnkleGirth(lines):
    ankleGirth = get_column(lines, 19)
    return ankleGirth

def get_height(lines):
    height = get_column(lines, 23)
    height = float(height)
    return height

def get_age(lines):
    age = get_column(lines, 21)
    age = float(age)
    return age

def get_weight(lines):
    weight = get_column(lines, 22)
    weight = float(weight)
    return weight

def calculate_bmi(weight, height):
    weight = float(weight)
    height = float(height)
    bmi = (weight/(height **2)) * 10000
    bmi = round(bmi, 1)
    return bmi

##Formula with physical attributes
def formula(chestDiam, chestDepth, bCDiameter, wristGirth, ankleGirth, height):
    chestDiam = float(chestDiam)
    chestDepth = float(chestDepth)
    bCDiameter = float(bCDiameter)
    wristGirth = float(wristGirth)
    ankleGirth = float(ankleGirth)
    height = float(height)
    bmi = (-110.0 + 1.34  *(chestDiam) + 1.54 * (chestDepth) + 1.20 * (bCDiameter) + 1.11 *(wristGirth) + 1.15 * (ankleGirth) + 0.177 * (height))
    bmi = round(bmi, 1)
    return bmi

##Takes in 2 two lists of values for x and y
def slope(x, y):
    numberOfPairs = 507.0
    sumX = sum(x)
    sumY = sum(y)
    xy = []
    for i in range(0, len(x)):
        xy.append(x[i] * y[i])
    sumXY = sum(xy)
    xSquared = [i ** 2 for i in x]
    ySquared = [i ** 2 for i in y]
    
    sumXSquared = sum(xSquared)
    sumYSquared = sum(ySquared)
    
    ##Calculate slope
    slopeOf = (numberOfPairs*sumXY - (sumX*sumY))/(numberOfPairs*sumXSquared - (sumX)**2)
    return slopeOf

def intercept(x, y):
    numberOfPairs = 507.0
    sumX= sum(x)
    sumY= sum(y)
    ##Calculate intercept
    interceptOf = (sumY - (slope(x, y) * sumX)) / (numberOfPairs)
    return interceptOf

def correlation(x, y):
    numberOfPairs = 507.0
    sumX = sum(x)
    sumY = sum(y)
    xy = []
    for i in range(0, len(x)):
        xy.append(x[i] * y[i])
    sumXY = sum(xy)
    xSquared = [i ** 2 for i in x]
    ySquared = [i ** 2 for i in y]
    
    sumXSquared = sum(xSquared)
    sumYSquared = sum(ySquared)
    
    corr = (numberOfPairs*sumXY - (sumX*sumY)) / sqrt((numberOfPairs*sumXSquared - (sumX)**2) * (numberOfPairs*sumYSquared - (sumY)**2))
    print ("The Correlation is: "  + str(round(corr, 3)))

if __name__ == "__main__":
    main()