//
//  textSend.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 5/3/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import Foundation
import UIKit
import MessageUI

class textSend: UIViewController, MFMessageComposeViewControllerDelegate {
    
    func sendSMSText(phoneNumber: String, message: String) {
        if (MFMessageComposeViewController.canSendText()) {
            let controller = MFMessageComposeViewController()
            controller.body = message
            controller.recipients = [phoneNumber]
            controller.messageComposeDelegate = self as! MFMessageComposeViewControllerDelegate
            self.present(controller, animated: true, completion: nil)
        }else{
            print("Can't send text")
        }
    }
    
    func messageComposeViewController(_ controller: MFMessageComposeViewController, didFinishWith result: MessageComposeResult) {
        //... handle sms screen actions
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        self.navigationController?.isNavigationBarHidden = false
    }
    
}
    

