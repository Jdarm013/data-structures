package edu.dccc.datastructures;

import java.io.*;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

public class DoublyLinkedListPhonebook {

    // Represent the head and tail of the doubly linked list
    Node head, tail = null;

    // Inner class representing a node in the list
    class Node {
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }

    // 1. Add a new node to the end of the list
    public void addNode(PhonebookData data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    // 2. Display the list
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }

    // 3. Search head-first
    public SortedSet<PhonebookData> search(String searchItem) {
        SortedSet<PhonebookData> sortedSet = new TreeSet<>();
        Node current = head;

        while (current != null) {
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) ||
                    current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add(current.data);
            }
            current = current.next;
        }
        return sortedSet;
    }

    // 4. Search tail-first
    public SortedSet<PhonebookData> searchTailFirst(String searchItem) {
        SortedSet<PhonebookData> sortedSet = new TreeSet<>();
        Node current = tail;

        if (tail == null) {
            System.out.println("List is empty");
            return null;
        }

        while (current != null) {
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) ||
                    current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add(current.data);
            }
            current = current.previous;
        }
        return sortedSet;
    }

    // 5. Extra Credit: Read from CSV
    public LinkedList<PhonebookData> getPhonebookListFromCSV(String filePath) {
        LinkedList<PhonebookData> phoneList = new LinkedList<>();
        String line = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    phoneList.add(new PhonebookData(data[0].trim(), data[1].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("File not found or error reading file: " + filePath);
        }
        return phoneList;
    }

    // 6. Extra Credit: Write to CSV
    public void writePhonebookData(String outputFile) throws IOException {
        Node current = head;
        SortedSet<PhonebookData> sortedSet = new TreeSet<>();

        if (head == null) {
            System.out.println("List is empty, nothing to save.");
            return;
        }

        // Save current list to a SortedSet to enable removing of duplicates.
        while (current != null) {
            sortedSet.add(current.data);
            current = current.next;
        }

        // Write unique items to the file
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(outputFile))) {
            for (PhonebookData node : sortedSet) {
                // Formatting as CSV
                outputStream.write(node.getName() + "," + node.getMobilePhone() + "\n");
            }
        }
    }
}