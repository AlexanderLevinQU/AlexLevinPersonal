//
//  CnnController.swift
//  
//
//  Created by Levin, Alexander J. on 5/4/18.
//

import Foundation
import UIKit
import WebKit

class CnnController: UIViewController, WKUIDelegate {
    
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
        let webURL = URL(string: "https://news.google.com/news/?ned=us&gl=US&hl=en")
        let urlRequest = URLRequest(url: webURL!)
        webView.load(urlRequest)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}

