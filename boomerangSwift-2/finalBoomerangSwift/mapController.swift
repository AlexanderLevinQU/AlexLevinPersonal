//
//  mapController.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 2/26/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//

import Foundation
import MapKit
import UIKit

class mapController: UIViewController, UITextFieldDelegate {
    var regionRadius:CLLocationDistance = 1000
    var matchingItems:[MKMapItem] = [MKMapItem]()
    @IBOutlet weak var searchMapText: UITextField!
    @IBAction func searchMap(_ sender: Any) {
        //Constant for local search request in our region(results)
        let searchRequest = MKLocalSearchRequest()
        searchRequest.naturalLanguageQuery = searchMapText.text //term to search
        searchRequest.region = mapView.region // region to search(current)
        let search = MKLocalSearch(request: searchRequest)
        //asychronyous so map doesn't freeze until search
        search.start(completionHandler: {(response, error) in
            if error != nil{
                // there was no error in search
            }else if response!.mapItems.count == 0{
                //if nothing gets returned...
            }else{
                //Congrats something got returned lets parse
                for item in response!.mapItems{
                    print("Name =\(item.name)")
                    
                    //Add result to the array of map items
                    self.matchingItems.append(item as MKMapItem)
                    print("Number of matching items = \(self.matchingItems.count)")
                    //Now lets add annotations for the places
                    let annotation = MKPointAnnotation()
                    annotation.coordinate = item.placemark.coordinate
                    annotation.title = item.name
                    self.mapView.addAnnotation(annotation)
                    //use self to make it explicit where its going(mapController is a no go)
                }//for loop
            }// else
        })//block
        
        
    }
    @IBOutlet weak var slider: UISlider!
    
    var mapChange = false // For map changing
    @IBAction func changeMapType(_ sender: Any) {
        if(mapChange == false){
        //Changes map Type
        mapView.mapType = MKMapType.hybrid
            //Change mapview
            mapChange = true
        }else{
            //Change map
            mapView.mapType = MKMapType.standard
            //Change mapview back
            mapChange = false
        }
    }
    @IBOutlet weak var mapView: MKMapView!
    @IBAction func mapSlider(_ sender: UISlider) {
        //let rangeInMiles = Double(self.slider.value)//For controlling slider
        //68.703->69.407 miles for each degree of lat/long
        //let delta:Double = rangeInMiles/69.0

        //get current location
        //var currentPlace = self.mapView.region
        //makes a MKCoordinateSpan for slider to use to zoom
        //currentPlace.span = MKCoordinateSpan(latitudeDelta: delta, longitudeDelta: delta)
        
        //now want to recenter
        //self.mapView.region = currentPlace
        var currentValue = Float(sender.value)
        print (currentValue)
        
        let initialLocation = CLLocation(latitude:41.4197, longitude: -72.8952)
        
        //Now Center map
        //reverse slider
        regionRadius = CLLocationDistance((100 - currentValue) * (1000 * 0.621371))
        
        let coordinateRegion = MKCoordinateRegionMakeWithDistance(initialLocation.coordinate, regionRadius, regionRadius)
        mapView.setRegion(coordinateRegion, animated: true)

        
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        //So it zooms in correctly
        //slider.transform = CGAffineTransform(rotationAngle: CGFloat(Double.pi))
        searchMapText.delegate = self
        
        slider.minimumValue = 0
        slider.maximumValue = 97
        slider.value = slider.maximumValue/2
        
        //show user Location
        mapView.showsUserLocation = true
        
        //zoom in on initial location
        let initialLocation = CLLocation(latitude:41.4197, longitude: -72.8952)
        //.62 is conversion
        regionRadius = CLLocationDistance((100 - slider.value) * (1000 * 0.621371))
        
        //Now Center map
        let coordinateRegion = MKCoordinateRegionMakeWithDistance(initialLocation.coordinate, regionRadius, regionRadius)
        mapView.setRegion(coordinateRegion, animated: true)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    //Dissmiss keyboard
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        super.touchesBegan(touches, with:event)
        self.view.endEditing(true)
    }

    
}
