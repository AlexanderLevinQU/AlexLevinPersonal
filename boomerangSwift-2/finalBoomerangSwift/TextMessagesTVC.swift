//
//  TwitterMessagesTVC.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 4/26/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import UIKit
import CoreData
import MessageUI

var textClass = textSend()

protocol tableViewDelegate : class {
    func tableViewCellDidTapSend(_ sender: customTableViewCellMessages)
}
class customTableViewCellMessages: UITableViewCell{
   
    @IBOutlet weak var messageID: UILabel!
    @IBOutlet weak var timeSendingID: UILabel!
    @IBOutlet weak var numberOrPerson: UILabel!
    
    @IBAction func sendButton(_ sender: Any) {
        delegate?.tableViewCellDidTapSend(self)
    }
    weak var delegate: tableViewDelegate?
    
}

class TextMessagesTVC: UITableViewController, tableViewDelegate, MFMessageComposeViewControllerDelegate {
    
    func tableViewCellDidTapSend(_ sender: customTableViewCellMessages) {
        guard let tappedIndexPath = tableView.indexPath(for: sender) else { return }
        let selectedItem = dataArray[tappedIndexPath.row]
        //Write function here
        if MFMessageComposeViewController.canSendText() {
            //Declare our viewController
            let composeVC = MFMessageComposeViewController()
            composeVC.messageComposeDelegate = self
            
            // Configure the fields of the interface.
            composeVC.recipients = [selectedItem.value(forKey: "numberOrPerson") as! String]
            composeVC.body = selectedItem.value(forKey:"message") as? String
            
            // Present the view controller modally.
            self.present(composeVC, animated: true, completion: nil)
        }else{
            print("SMS services are not available")
        }
    }
    func messageComposeViewController(controller: MFMessageComposeViewController,
                                      didFinishWithResult result: MessageComposeResult) {
        // Check the result or perform other tasks.
        
        // Dismiss the message compose view controller.
        controller.dismiss(animated: true, completion: nil)}
    
    func messageComposeViewController(_ controller: MFMessageComposeViewController, didFinishWith result: MessageComposeResult) {
        //... handle sms screen actions
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        self.navigationController?.isNavigationBarHidden = false
    }
    

    var dataArray:[NSManagedObject] = []

    override func viewDidLoad() {
        super.viewDidLoad()

       //Create some Email Messages
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        let textContext = appDelegate.persistentContainer.viewContext
        
        tableView.dataSource = self
        tableView.delegate = self
        
        let fetchRequest = NSFetchRequest<NSManagedObject>(entityName: "TextMessages")
        fetchRequest.returnsObjectsAsFaults = false
        do{
            dataArray = try textContext.fetch(fetchRequest)
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
        return dataArray.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "composedTextsID", for: indexPath) as! customTableViewCellMessages //Must identify it is a custom cell
        // Configure the cell...
        let textMessage = dataArray[indexPath.row]
        cell.delegate = self
        cell.messageID?.text = textMessage.value(forKey:"message") as? String
        cell.numberOrPerson?.text = textMessage.value(forKey:"numberOrPerson") as? String
        cell.timeSendingID?.text = textMessage.value(forKey:"timeSending") as? String
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
            let textContext = appDelegate.persistentContainer.viewContext
            textContext.delete(data)
            
            //Delete object from array
            dataArray.remove(at: indexPath.row)
            
            //Delete from tableview
            tableView.beginUpdates()
            tableView.deleteRows(at: [indexPath], with: .fade)
            tableView.endUpdates()
            //Delete object from data store
            do{
                try textContext.save()
                
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

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
