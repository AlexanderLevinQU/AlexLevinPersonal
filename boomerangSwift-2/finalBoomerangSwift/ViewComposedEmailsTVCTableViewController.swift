//
//  ViewComposedEmailsTVCTableViewController.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 4/26/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import UIKit
import CoreData
import MessageUI

var emailClass = emailSend()
protocol tableViewDelegateEmail : class {
    func tableViewCellDidTapSendEmail(_ sender: customTableViewCell)
}

//Work with our class
class customTableViewCell: UITableViewCell {
    @IBOutlet weak var message: UILabel!
    @IBOutlet weak var timeLeftForSent: UILabel!
    @IBOutlet weak var subject: UILabel!
    @IBOutlet weak var emailSendingToo: UILabel!
    @IBAction func sendEmail(_ sender: Any) {
        delegate?.tableViewCellDidTapSendEmail(self)
    }
    weak var delegate: tableViewDelegateEmail?

    
    
    
}

class ViewComposedEmailsTVCTableViewController: UITableViewController, MFMailComposeViewControllerDelegate, tableViewDelegateEmail {
    var dataArray: [NSManagedObject] = []
    
    
    func tableViewCellDidTapSendEmail(_ sender: customTableViewCell) {
        guard let tappedIndexPath = tableView.indexPath(for: sender) else { return }
        let selectedItem = dataArray[tappedIndexPath.row]
        if MFMailComposeViewController.canSendMail() {
            let composeVC = MFMailComposeViewController()
            composeVC.mailComposeDelegate = self
            
            // Configure the fields of the interface.
        composeVC.setToRecipients([selectedItem.value(forKey: "emailSendingToo") as! String])
        
            composeVC.setSubject(selectedItem.value(forKey: "subject") as! String)
        composeVC.setMessageBody(selectedItem.value(forKey: "mesage") as! String, isHTML: false)
            
            // Present the view controller modally.
            self.present(composeVC, animated: true, completion: nil)
        }else{
            print("Services not avaliable")
        }

        
    }
    func mailComposeController(_ controller: MFMailComposeViewController, didFinishWith result: MFMailComposeResult, error: Error?) {
        //Dismiss after
        controller.dismiss(animated: true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        let emailsContext = appDelegate.persistentContainer.viewContext
        
        tableView.dataSource = self
        tableView.delegate = self
        
        let fetchRequest = NSFetchRequest<NSManagedObject>(entityName: "EmailMessages")
        fetchRequest.returnsObjectsAsFaults = false
        do{
            dataArray = try emailsContext.fetch(fetchRequest)
        }catch{
            print("Failed Fetch")
        }
        

        
    }
 

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        //Count of rows
        return dataArray.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "composedEmailsID", for: indexPath) as! customTableViewCell //Must identify it is a custom cell
        
        // Configure the cell...
        let email = dataArray[indexPath.row]
        cell.delegate = self
        cell.emailSendingToo.text = email.value(forKey: "emailSendingToo") as? String
        cell.message?.text = email.value(forKey:"mesage") as? String
        cell.subject?.text = email.value(forKey: "subject") as? String
        cell.timeLeftForSent?.text = email.value(forKey: "timeSending") as? String
        return cell
        
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 128
    }

    
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
 

    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            //Get name to delete
            let data = dataArray[indexPath.row]
            let appDelegate = UIApplication.shared.delegate as! AppDelegate
            let emailsContext = appDelegate.persistentContainer.viewContext
            emailsContext.delete(data)
            
            //Delete object from array
            dataArray.remove(at: indexPath.row)
            
            //Delete from tableview
            tableView.beginUpdates()
            tableView.deleteRows(at: [indexPath], with: .fade)
            tableView.endUpdates()
            //Delete object from data store
            do{
                try emailsContext.save()
                
            }catch{
                print("Failed deleting the party class")
            }
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

   
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    /*
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        let indexPath = tableView.indexPathForSelectedRow
        let viewMessageController = segue.destination as! viewMessageController
        
        let mySelectedEmail = dataArray[indexPath!.row]
        //viewMessageController.catchEmail = mySelectedEmail //Whatever email I passed
    }
 */
    /*
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if MFMailComposeViewController.canSendMail() {
            print("Mail service is avalible")
            return
        }else{
            print("Mail service is not avalible")
        }
        let composeVC = MFMailComposeViewController()
        composeVC.mailComposeDelegate = self as! MFMailComposeViewControllerDelegate
        
        // Configure the fields of the interface.
        composeVC.setToRecipients([emailSendingToo.text!])
        composeVC.setSubject(subject.text!)
        composeVC.setMessageBody(message.text!, isHTML: false)
        
        // Present the view controller modally.
        self.presentViewController(composeVC, animated: true, completion: nil)
        
    }
 */
        
    }
    
    


