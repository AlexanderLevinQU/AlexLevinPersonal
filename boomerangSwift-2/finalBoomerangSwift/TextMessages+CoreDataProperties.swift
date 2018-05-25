//
//  TextMessages+CoreDataProperties.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 5/3/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//
//

import Foundation
import CoreData


extension TextMessages {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<TextMessages> {
        return NSFetchRequest<TextMessages>(entityName: "TextMessages")
    }

    @NSManaged public var message: String?
    @NSManaged public var numberOrPerson: String?
    @NSManaged public var timeSending: String?

}
