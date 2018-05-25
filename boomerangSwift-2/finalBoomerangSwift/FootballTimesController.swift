//
//  FootballTimesController.swift
//  
//
//  Created by Levin, Alexander J. on 5/4/18.
//

import UIKit
import WebKit

class FootballTimesController: UIViewController, WKUIDelegate {
    var webView: WKWebView!
    
    
    override func loadView() {
        super.loadView()
        let webConfig = WKWebViewConfiguration()
        webView = WKWebView(frame: .zero, configuration: webConfig)
        
        webView.uiDelegate = self
        
        //Make webview main view
        view = webView
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //Use URL
        let webURL = URL(string: "https://www.cbssports.com/nfl/news/2018-nfl-schedule-release-heres-the-time-and-date-for-all-256-games/")
        let urlRequest = URLRequest(url: webURL!)
        webView.load(urlRequest)
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
