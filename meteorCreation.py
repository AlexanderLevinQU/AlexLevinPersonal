''' Alex And Chris 
    Creating Databases 
    Project'''



import urllib2
import json
import sqlite3

##Need to just create the Tables and populate them now
def main():
    nasaData = getData()
    nasaTables = parseData(nasaData)
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    CreateTables(cursor, db)
    InsertValues(nasaTables, cursor, db)
    ##NOT SURE IF CLOSING CURSOR DOES ANYTHING
    cursor.close()
    db.close()
    


def getData():
    respond = urllib2.urlopen('https://data.nasa.gov/resource/y77d-th95.json')
    data = respond.read()
    return data

def parseData(data):
    info = json.loads(data)
    meteor = {}
    geolocation = {}
    name = {}
    meteorArray = []
    geolocationArray = []
    nameArray = []
    for item in info:
        ##Changes dict everytime
        ##Uses excess space with not determined errors in try and catch blocks
        ##Put items in dictionaries
        ##Do try blocks for when doesn't have value
        meteor['ID'] = item['id']
        meteor['name'] = item['name']
        meteor['fall'] = item['fall']
        try:
            meteor['year'] = item['year']
        except:
            meteor['year'] = None
        try:          
            meteor['mass'] = item['mass']
        except:
            meteor['mass'] = None
        geolocation['ID'] = item['id']
        ##geolocation['type'] = item['geolocation']['type']
        try:
            geolocation['reclat'] = item['reclat']
        except:
            geolocation['reclat'] = None
        try:
            geolocation['reclong'] = item['reclong']
        except:
            geolocation['reclong'] = None
        try:
            geolocation['recclass'] = item['recclass']
        except:
            geolocation['recclass'] = None
        name['name'] = item['name']
        name['nametype'] = item['nametype']
        '''
        meteor = {'ID': item['id'], 'name' : item['name'], 'fall': item['fall'], 'year' : item['year'], 'mass': item['mass']}
        geolocation = {'ID': item['id'], 'type': item['geolocation']['type'], 'reclat': item['reclat'], 'reclong': item['reclong'], 'recclass': item['recclass']}
        name = {'name': item['name'], 'nametype' : item['nametype']}
        '''
        ##Must use copies to add in to array or will populate with the last one        
        meteorArray.append(meteor.copy())
        geolocationArray.append(geolocation.copy())
        nameArray.append(name.copy())
        
    ##Put in an array of tables    
    allTables = [meteorArray, geolocationArray, nameArray]
    return allTables

def CreateTables(cursor, db):
    ##Might need 3rd table for coordinates
    ##First Create tables
    cursor.execute('DROP TABLE IF EXISTS Meteor')
    cursor.execute('DROP TABLE IF EXISTS Geolocation')
    cursor.execute('DROP TABLE IF EXISTS name')
    cursor.execute('DROP TABLE IF EXISTS Names')
    cursor.execute('CREATE TABLE Meteor (ID INTEGER PRIMARY KEY, name VARCHAR(30), fall VARCHAR(10), year TIMESTAMP, mass INTEGER, FOREIGN KEY(name) REFERENCES name(name))')
    cursor.execute('CREATE TABLE Geolocation(ID INTEGER, reclat FLOAT, reclong FLOAT, recclass FLOAT, PRIMARY KEY(ID, reclat, reclong), FOREIGN KEY(ID) REFERENCES Meteor(ID))')
    cursor.execute('CREATE TABLE Names(name VARCHAR(30) PRIMARY KEY, nametype VARCHAR(20))') 
    db.commit()
    
def InsertValues(tables, cursor, db):
    ##Pass in alltables
    meteor = tables[0]
    geoLocation = tables[1]
    name = tables[2]
    ##put in value from each array one at a time(each dict.)
    for item in meteor:
        ###Have to something Special for timeSTAMPS so they fit in right format
        newTime = str(item['year'])
        newTime = newTime.replace("T00:", " ")
        newTime = "TIMESTAMP" + "'" + newTime + "'"
        cursor.execute('INSERT INTO Meteor (ID, name, fall, year, mass) VALUES (?, ?, ?, ?, ?)',
                       (item['ID'], item['name'], item['fall'], newTime, item['mass']))
        
    for item in geoLocation:
        cursor.execute('INSERT INTO Geolocation(ID, reclat, reclong, recclass) VALUES (?, ?, ?, ?)',
                       (item['ID'], item['reclat'], item['reclong'], item['recclass']))
        
    for item in name:
        cursor.execute('INSERT INTO Names(name, nametype) VALUES (?, ?)',
                       (item['name'], item['nametype']))
    db.commit()

if __name__ == '__main__':
    main()