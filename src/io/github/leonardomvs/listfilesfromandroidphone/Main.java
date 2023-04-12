package io.github.leonardomvs.listfilesfromandroidphone;

import java.io.IOException;

import jmtp.PortableDevice;
import jmtp.PortableDeviceManager;
import jmtp.PortableDeviceObject;
import jmtp.PortableDeviceStorageObject;

public class Main {

	/**
	 * In order to work, you have to do the following steps:
	 * 
	 * 1 - Right Click on your project -> Properties
	 * 2 - Java Build Path
	 * 3 - Tab Source
	 * 4 - Open the tree
	 * 5 - Native Library Location -> Edit
	 * 6 - Select 'dll' folder of the project
	 */
	
	/**
	 * jmtpe.jar generated from the following project:
	 * 
	 * https://github.com/mheinzerling/jMTPe
	 * @throws IOException 
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		
		Main main = new Main();		
		
		main.listDevices();
		
//		int deviceIndex = 0;		
//		main.printFolders(deviceIndex);
						
    }
		
	public void printFolders(int deviceIndex) {

		PortableDevice device = getDeviceByIndex(deviceIndex);
		
		try {
		
			device.open();
	
			for(PortableDeviceObject object : device.getRootObjects()){
				printStorage(object);
			}
			
		} finally {
			device.close();
			device = null;
		}

	}

	public void listDevices(){		
		
		int numberOfConnectedDevices = getNumberOfConnectedDevices();
		
		if(numberOfConnectedDevices == 0) {
			System.out.println("No devices were found connected.");
			return;
		}
		
		for(int i = 0; i < numberOfConnectedDevices; i++) {
			printDevice(i);
		}
		
	}
	
	private PortableDevice getDeviceByIndex(int deviceIndex) {
		PortableDeviceManager manager = new PortableDeviceManager();
		PortableDevice[] arrayDevices = manager.getDevices();
		return arrayDevices[deviceIndex];
	}
	
	private int getNumberOfConnectedDevices() {
		PortableDeviceManager manager = new PortableDeviceManager();		
		PortableDevice[] arrayDevices = manager.getDevices();
		return arrayDevices.length;
	}
	
	private void printDevice(int deviceIndex) {
		
		PortableDevice device = getDeviceByIndex(deviceIndex);
		
		try {
		
			device.open();
			System.out.println("=============================================================================================================================");
			System.out.println("DeviceIndex: " + deviceIndex);
			System.out.println("FriendlyName: " + device.getFriendlyName());
			System.out.println("Description: " + device.getDescription());
			System.out.println("FirmwareVersion: " + device.getFirmwareVersion());		
			System.out.println("Manufacturer: " + device.getManufacturer());
			System.out.println("Model: " + device.getModel());
			System.out.println("PowerLevel: " + device.getPowerLevel());			
			System.out.println("Protocol: " + device.getProtocol());
			System.out.println("SerialNumber: " + device.getSerialNumber());
			System.out.println("SyncPartner: " + device.getSyncPartner());
			System.out.println("Type: " + device.getType());
			
		} finally {
			device.close();	
		}
		
	}
	
	private void printStorage(PortableDeviceObject object) {
		
		if(!(object instanceof PortableDeviceStorageObject)) { return; }
		
		PortableDeviceStorageObject storage = (PortableDeviceStorageObject) object;
		
		for(PortableDeviceObject folder:storage.getChildObjects()) {
			
			String folderName = folder.getOriginalFileName();
			
			System.out.println(folderName);

		}
		
	}
	
}