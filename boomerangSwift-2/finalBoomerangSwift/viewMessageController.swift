//
//  viewMessageController.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 2/26/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import Foundation
import UIKit
import CoreData
import UserNotifications

class viewMessageController: UIViewController, UNUserNotificationCenterDelegate {
    
    @IBOutlet weak var usersMessage: UILabel!
    @IBOutlet weak var emailSendingToo: UILabel!
    @IBOutlet weak var numberSendingToo: UILabel!
    
    @IBOutlet weak var subject: UILabel!
    @IBOutlet weak var timeWhenSending: UILabel!
 
   var catchEmail = emailMessage()
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.title = "Post message"
        usersMessage.text = catchEmail.message
        emailSendingToo.text = catchEmail.emailSendingToo
        timeWhenSending.text = catchEmail.timeSent
        subject.text = catchEmail.subject
        numberSendingToo.text = catchEmail.numberSendingToo
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func saveToEmails(_ sender: Any) {
        //Declare objects that we need for core data
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        let emailsContext = appDelegate.persistentContainer.viewContext
        
        //Work with our class
        let emailMessages = NSEntityDescription.entity(forEntityName: "EmailMessages", in: emailsContext)
        let newEmailMessage = NSManagedObject(entity: emailMessages!, insertInto: emailsContext) //emailMessages, and EmailMessages are diff
        newEmailMessage.setValue(usersMessage.text, forKey: "mesage")
        newEmailMessage.setValue(emailSendingToo.text, forKey: "emailSendingToo")
        newEmailMessage.setValue(subject.text, forKey:"subject")
        newEmailMessage.setValue(timeWhenSending.text, forKey:"timeSending")
        
        //May have to convert this to Date time format before
        //This is yyyy/MM/dd HH:mm
        let dateTime = convertToDate(date: timeWhenSending.text!)
        //Create a unique identifier for notification
        let uniqueIdentifier = usersMessage.text
        notification(date: dateTime, uniqueIdentifier: uniqueIdentifier!, message: usersMessage.text!)
        
        //Now we save to storage
        do{
            try emailsContext.save()
        }catch{
            print("Failed Saving")
        }
        
        //Add alert email has been added
        let alert = UIAlertController(title: "Boomerang Email Added" , message: "Boomerang with subject: " + subject.text! + " added" , preferredStyle: .alert)
        
        //Create action button
        let defaultAction = UIAlertAction(title: "Ok", style: .default){ (action) in
            //Nothing happens just lets them know
        }
        alert.addAction(defaultAction)
        self.present(alert, animated: true, completion: nil)
    }
    
    func convertToDate(date:String) -> Date{
        let dateFormatter = DateFormatter()
        //
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss Z"
        let dateConverted = dateFormatter.date(from: date)
        print(dateConverted)
        return dateConverted!
    }
    
    @IBAction func saveToTextMessages(_ sender: Any) {     //Declare objects that we need for core data
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        let textContext = appDelegate.persistentContainer.viewContext
        
        //Work with our class
        let textMessages = NSEntityDescription.entity(forEntityName: "TextMessages", in: textContext)
        let newTextMessage = NSManagedObject(entity: textMessages!, insertInto: textContext) //textMessages, and EmailMessages are diff
        newTextMessage.setValue(usersMessage.text, forKey: "message")
        newTextMessage.setValue(numberSendingToo.text, forKey:"numberOrPerson")
        newTextMessage.setValue(timeWhenSending.text, forKey:"timeSending")
        
        //May have to convert this to Date time format before
        //This is yyyy/MM/dd HH:mm:ss
        let dateTime = convertToDate(date: timeWhenSending.text!)
        //Create a unique identifier for notification
        let uniqueIdentifier = usersMessage.text
        notification(date: dateTime, uniqueIdentifier: uniqueIdentifier!, message: usersMessage.text!)
        
        //Now we save to storage
        do{
            try textContext.save()
        }catch{
            print("Failed Saving")
        }
        
        //Add alert text has been added
        let alert = UIAlertController(title: "Boomerang Added" , message: "Bommerang Text: " + usersMessage.text! + " added" , preferredStyle: .alert)
        
        //Create action button
        let defaultAction = UIAlertAction(title: "Ok", style: .default){ (action) in
            //Nothing happens just lets them know
        }
        alert.addAction(defaultAction)
        self.present(alert, animated: true, completion: nil)
        
        
    }
    //Func to set up a notification
    func notification(date:Date, uniqueIdentifier:String, message:String){
        
        
        //Set up date for trigger component
        let calendar = Calendar(identifier: .gregorian)
        let components = calendar.dateComponents(in:.current, from: date)
        var datecomps = DateComponents()
        datecomps.year = components.year
        datecomps.month = components.month
        datecomps.day = components.day
        datecomps.hour = components.hour
        datecomps.minute = components.minute
        
        print(datecomps)
        //it will be called at a date
        //Something is wrong with the date unsure what it is.
        let trigger = UNCalendarNotificationTrigger(dateMatching: datecomps, repeats: false)
        //let trigger = UNTimeIntervalNotificationTrigger(timeInterval: 10.0, repeats: false)
        let content = UNMutableNotificationContent()
        
        //adding title, subtitle, body and badge
        content.title = "Message Ready to send"
        content.body = message
        content.badge = 1
        
        //getting the notification request
        let request = UNNotificationRequest(identifier: uniqueIdentifier, content: content, trigger: trigger)
        
        //adding the notification to notification center
        UNUserNotificationCenter.current().add(request) {(error) in
            if let error = error {
                print("We have an error: \(error)")
            }
        }
        print("It Fired")
    }
   
 

}
