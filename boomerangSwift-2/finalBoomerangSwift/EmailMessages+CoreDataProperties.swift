//
//  EmailMessages+CoreDataProperties.swift
//  finalBoomerangSwift
//
//  Created by Levin, Alexander J. on 5/2/18.
//  Copyright © 2018 Levin, Alexander J. All rights reserved.
//
//

import Foundation
import CoreData


extension EmailMessages {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<EmailMessages> {
        return NSFetchRequest<EmailMessages>(entityName: "EmailMessages")
    }

    @NSManaged public var emailSendingToo: String?
    @NSManaged public var mesage: String?
    @NSManaged public var subject: String?
    @NSManaged public var timeSending: String?

}
