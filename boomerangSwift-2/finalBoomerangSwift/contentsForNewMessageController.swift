//
//  contentsForNewMessageController.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 2/26/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import Foundation
import UIKit

class contentsForNewMessageController: UIViewController, UITextViewDelegate, UITextFieldDelegate {
    
    @IBOutlet weak var userNameContentsText: UITextField! //This is subject
    @IBOutlet weak var emailSendingContentsText: UITextField!

    @IBOutlet weak var datePick: UIDatePicker!
    
    @IBOutlet weak var newMessageSendingContentsText: UITextView!
    @IBOutlet weak var numberSendingContentsText: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()
        //Create delegates for making keyboard go away
        newMessageSendingContentsText.delegate = self
        userNameContentsText.delegate = self
        emailSendingContentsText.delegate = self
        numberSendingContentsText.delegate = self
        
        
        
        
        //Add message for textView make it mimic textfield placeholder text
        newMessageSendingContentsText.text = "Enter New Message Here"
        newMessageSendingContentsText.textColor = UIColor.lightGray
        //Make it dissapear
        textViewDidBeginEditing(newMessageSendingContentsText)
        //If nothing added put it back to before
        textViewDidEndEditing(newMessageSendingContentsText)
        
        
        
        
        self.title = "Compose A Message"
        
        //If email or text changed
        emailSendingContentsText.addTarget(self, action: #selector(emailTextFieldDidChange(_:)), for: .editingChanged)
        numberSendingContentsText.addTarget(self, action: #selector(numberTextFieldDidChange(_:)), for: .editingChanged)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "savedInfo"{
            let destinationViewController = segue.destination as! viewMessageController
            destinationViewController.catchEmail.subject = userNameContentsText.text!
            
            destinationViewController.catchEmail.emailSendingToo = emailSendingContentsText.text!
            
            destinationViewController.catchEmail.timeSent =
            datePick.date.description
            
            destinationViewController.catchEmail.numberSendingToo = numberSendingContentsText.text!
            
            destinationViewController.catchEmail.message = newMessageSendingContentsText.text!
        }else if segue.identifier == "savedInfoDown"{
            let destinationViewController = segue.destination as! viewMessageController
            destinationViewController.catchEmail.subject = userNameContentsText.text!
            
            destinationViewController.catchEmail.emailSendingToo = emailSendingContentsText.text!
            
            destinationViewController.catchEmail.timeSent =
                datePick.date.description
            
            destinationViewController.catchEmail.numberSendingToo = numberSendingContentsText.text!
            
            destinationViewController.catchEmail.message = newMessageSendingContentsText.text!
        }
 
        
    }
    @IBAction func clearContents(_ sender: Any) {
        userNameContentsText.text = ""
        emailSendingContentsText.text = ""
        newMessageSendingContentsText.text = ""
        numberSendingContentsText.text = ""
    }
    
    @objc func emailTextFieldDidChange(_ textField: UITextField) {
        numberSendingContentsText.text = ""
    }
    @objc func numberTextFieldDidChange(_ textField: UITextField) {
        emailSendingContentsText.text = ""
        userNameContentsText.text = ""
    }
    
    func textViewDidBeginEditing(_ textView: UITextView) {
        if textView.textColor == UIColor.lightGray {
            textView.text = nil
            textView.textColor = UIColor.black
        }
    }
    
    func textViewDidEndEditing(_ textView: UITextView) {
        if textView.text.isEmpty {
            textView.text = "Enter New Message Here"
            textView.textColor = UIColor.lightGray
        }
    }
    //Dissmiss keyboard
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        super.touchesBegan(touches, with:event)
        self.view.endEditing(true)
    }
    
    //Also dismiss keyboard on return for textView
    func textView(_ textView: UITextView, shouldChangeTextIn range: NSRange, replacementText text: String) -> Bool {
        if(text == "\n") {
            textView.resignFirstResponder()
            return false
        }
        return true
    }
    
    //Dismiss on return for textField
    func textFieldShouldReturn(_ textField: UITextField)-> Bool{
        textField.resignFirstResponder()
        return true
    }
    
    

    
}
