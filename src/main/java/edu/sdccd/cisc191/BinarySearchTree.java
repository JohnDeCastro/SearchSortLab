package edu.sdccd.cisc191;

public class BinarySearchTree {
    /**
     * Recursively finds the needle in the Binary Search Tree (BST) haystack
     * @param root which node to start searching from
     * @param needle the data to search for
     * @return the first BSTNode containing the needle, null if doesn't exist
     */
    public BSTNode contains(BSTNode root, String needle) {
        // TODO: fill this out, you can choose any order of traversal
        if(root == null){ //reached leafed nodes if root == null
            return null; //needle is not in BST, return null
        }
        else if(needle.equals(root.getData())){
            return root; //item found in root node, return root
        }
        else if(needle.compareTo(root.getData()) < 0){ //checks to see if needle is less than root data
            return contains(root.getLeft(), needle); //if yes, recursively traverse via left subtree
        }
        else { //else if needle is bigger than root data
            return contains(root.getRight(), needle); //recursively traverse via right subtree
        }
    }

    /**
     * Recursively converts a String array to Binary Search Tree (BST)
     * @param array the array of Strings to import into the BST
     * @param start index in the array to begin importing
     * @param end index in the array to stop importing
     * @return the root node of the generated BST
     */
    public BSTNode fromArray(String[] array, int start, int end) {
        // TODO: fill this out, you can choose any order of traversal
        if (start > end){
            return null; //if start is greater than end, return null
        }
        else {
            int middle = (start + end) / 2; //create middle node tracker
            BSTNode root = new BSTNode(array[middle]); //set middle of array as new root

            //recursively sets left subtrees by calling root.setLeft() and setting param as a call to fromArray() recursively.
            //doing this will continuously shrink inserted param until base case sets leaf node pointers to null
            //thus completing left subtree
            root.setLeft(fromArray(array, start, middle - 1));

            //recursively sets right subtrees like the method above.
            root.setRight(fromArray(array, middle + 1, end));
            return root; //return root of BST
        }
    }
}