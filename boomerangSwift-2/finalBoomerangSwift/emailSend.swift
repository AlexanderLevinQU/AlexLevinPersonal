//
//  emailSend.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 5/3/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import UIKit
import MessageUI

class emailSend: UIViewController, MFMailComposeViewControllerDelegate{
    
    func emailPresent(mailComposeViewController: MFMailComposeViewController){
        
        if MFMailComposeViewController.canSendMail() {
            self.present(mailComposeViewController, animated: true, completion: nil)
        } else {
            self.showSendMailErrorAlert()
        }
    }

    func configuredMailComposeViewController(emailAddress:String, subject:String, message:String) -> MFMailComposeViewController {
        let mailComposerVC = MFMailComposeViewController()
        mailComposerVC.mailComposeDelegate = self as! MFMailComposeViewControllerDelegate// Extremely important to set the --mailComposeDelegate-- property, NOT the --delegate-- property
        
        mailComposerVC.setToRecipients([emailAddress])
        mailComposerVC.setSubject(subject)
        mailComposerVC.setMessageBody(message, isHTML: false)
        
        return mailComposerVC
    }

    func showSendMailErrorAlert() {
        let sendMailErrorAlert = UIAlertController(title: "Could not send email", message: "Your device could not send email", preferredStyle: .alert)
        let dismiss = UIAlertAction(title: "Ok", style: .default, handler: nil)
        sendMailErrorAlert.addAction(dismiss)
        self.present(sendMailErrorAlert, animated: true, completion: nil)
    }

    
    func mailComposeController(_ controller: MFMailComposeViewController, didFinishWith result: MFMailComposeResult, error: Error?) {
        controller.dismiss(animated: true, completion: nil)
    }
    
}
