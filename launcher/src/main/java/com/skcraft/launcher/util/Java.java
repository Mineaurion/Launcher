package com.skcraft.launcher.util;


import javax.swing.JOptionPane;

import com.skcraft.launcher.Launcher;
import com.skcraft.launcher.swing.SwingHelper;

import lombok.NonNull;






public class Java {

	 private static Launcher launcher;
	 
	public Java(@NonNull Launcher launcher1) {
		launcher = launcher1;
	}
	
	public static boolean checkBitVersion() {
		String bit = System.getProperty("sun.arch.data.model");
		if(bit.equalsIgnoreCase("64")) {
			return true;
		}else {
			return false;
		}
	}
	public static  boolean checkBitAndRam() {
		String bit = System.getProperty("sun.arch.data.model");
		if(bit.equalsIgnoreCase("64")) {
			return true;
		}else {
			if(launcher.getConfig().getMaxMemory()>=4096) {
				return false;
			}else {
				return true;
			}
		}
	}
	public static void showErrorMenu() {
		JOptionPane jop = new JOptionPane();
		int option = jop.showConfirmDialog(null, SharedLocale.tr("java.error32bit"),"Error Java 32 bit detected",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(option == JOptionPane.YES_OPTION) {
			SwingHelper.openURL("http://javadl.oracle.com/webapps/download/AutoDL?BundleId=234474_96a7b8442fe848ef90c96a2fad6ed6d1", jop);
		}
	}
}
