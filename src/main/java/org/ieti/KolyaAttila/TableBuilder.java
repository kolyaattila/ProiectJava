package org.ieti.KolyaAttila;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TableBuilder {

	public void buildTable(String[][] content, String[] headers) {
		JFrame container = new JFrame("Table");
		container.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JTable table = new JTable(content, headers);

		table.setCellSelectionEnabled(true);

		ListSelectionListenerImpl listSelectionListener = new ListSelectionListenerImpl(table);

		ListSelectionModel select = table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		select.addListSelectionListener(listSelectionListener);

		JScrollPane scrollPane = new JScrollPane(table);

		container.add(scrollPane);
		container.setLayout(new BorderLayout());
		container.add(table.getTableHeader(), BorderLayout.PAGE_START);
		container.add(table, BorderLayout.CENTER);
		container.setVisible(true);
		container.setSize(300, 400);
	}

}
