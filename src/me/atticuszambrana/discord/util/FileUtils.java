package me.atticuszambrana.discord.util;

import java.io.File;

public class FileUtils {
	public static String getReasonForFileDeletionFailureInPlainEnglish(File file) {
	    try {
	        if (!file.exists())
	            return "It doesn't exist in the first place.";
	        else if (file.isDirectory() && file.list().length > 0)
	            return "It's a directory and it's not empty.";
	        else
	            return "Somebody else has it open, we don't have write permissions, or somebody stole my disk.";
	    } catch (SecurityException e) {
	        return "We're sandboxed and don't have filesystem access.";
	    }
	}
}
