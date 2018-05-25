//
//  registerController.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 2/26/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import Foundation
import UIKit

class registerController: UIViewController {
    
    @IBOutlet weak var userNameRegisterText: UITextField!
    @IBOutlet weak var emailRegisterText: UITextField!
    @IBOutlet weak var passwordText: UITextField!
    @IBOutlet weak var confirmPasswordRegisterText: UITextField!
    @IBAction func registerAccount(_ sender: Any) {
        NSLog("register Button Pressed");
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
