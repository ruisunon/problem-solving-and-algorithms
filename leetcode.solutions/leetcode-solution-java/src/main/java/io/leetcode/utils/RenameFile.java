package io.leetcode.utils;

import java.io.File;

public class RenameFile
{
  public void removeSpace(){
    // change file names in 'Directory':
    String absolutePath = "C:\\zoz.Solutions\\leetcode-java-solutions\\src\\main\\java\\Easy";
    File dir = new File(absolutePath);
    File[] filesInDir = dir.listFiles();
    int i = 0;
    for(File file:filesInDir) {
      i++;
      String name = file.getName();
      String newName =removespaces(name);
      String newPath = absolutePath + "\\" + newName;
      file.renameTo(new File(newPath));
      System.out.println(name + " changed to " + newName);
    }
  }

  // Remove all space characters
  public String removespaces(String input) {
      return input.replaceAll(" ", "");
      }

  public static void main(String[] args)
  {
    RenameFile rf = new RenameFile();
    System.out.println("Java rename files in directory : ");
    rf.removeSpace();
  }
}