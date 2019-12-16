package ua.nure.kravets.usermanagement171.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ua.nure.kravets.usermanagement171.User;

public class UserTableModel extends AbstractTableModel {

	private static final String[]  COLUMN_NAMES = {"ID", "���", "�������"};
	private static final Class[] COLUMN_CLASSES = {Long.class, String.class, String.class};
	private List users = null;
	private int rowIndex;
	private int columnIndex;
	
	public UserTableModel(Collection users) {
		this.users = new ArrayList (users);
		
	}

	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	public Class getColumnClass(int columnIndex) {
	
		return COLUMN_CLASSES [columnIndex];
	}

	public String getColumnName(int column) {
		
		return COLUMN_NAMES [column];
	}

	public int getRowCount() {
		return users.size();
	}

	public Object getValueAt(int arg0, int arg1) {
		User user = (User) users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return user.getId();
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName	();
		}
		return null;
	}

}
