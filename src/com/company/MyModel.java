package com.company;

import com.company.data.Federation;
import com.company.data.Monarchy;
import com.company.data.Republic;
import com.company.data.State;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel {
    public static Federation states=new Federation();
    @Override
    public int getRowCount() {
        return states.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    @Override
    public String getColumnName(int column) {
        switch (column){
            case(0):
                return "Id";
            case(1):
                return "Form of government";
            case(2):
                return "Title";
            case(3):
                return "Area";
            case(4):
                return "Population";
            case(5):
                return "Livelihood";
            case (6):
                return "Years of management";
            case (7):
                return "Name of Leader";
        }
        return "";
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Float.class;
            case 4:
                return Float.class;
            case 5:
                return Integer.class;
            case 6:
                return Integer.class;
            case 7:
                return String.class;
        }
        return String.class;
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return false;
        }
        return true;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        State state = states.get(rowIndex);
        switch (columnIndex){
            case(0):
                return rowIndex+1;
            case(1):
                if(state instanceof Republic){ return "Republic";}
                else {return "Monarchy";}
            case(2):
                return state.getTitle();
            case(3):
                return state.getArea();
            case(4):
                return state.getPopulation();
            case(5):
                return state.getLiveLihood();
            case (6):
                if(state instanceof Republic){ return ((Republic)state).getYears();}
                else {return " ";}
            case (7):
                if(state instanceof Monarchy){ return ((Monarchy)state).getNameBoss();}
                else {return " ";}

        }
        return null;
    }
    public void setValueAt(State state, int rowIndex) {
        states.set(rowIndex,state);
        this.fireTableDataChanged();
    }

    public State getValueAt(int rowIndex) {
        return states.get(rowIndex);
    }
    public void Add(State state) {
        states.add(state);
        this.fireTableDataChanged();
    }
    public void Remove(int id) {
        states.remove(id);
        this.fireTableDataChanged();
    }
}
