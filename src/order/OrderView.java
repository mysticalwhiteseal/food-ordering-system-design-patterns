package src.order;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import src.foodModel.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class OrderView extends JFrame
{
	private List<JButton> listOfItemButtons;
	private JPanel receipt;
	private JPanel centerPanel;
	private JPanel itemButtonPanel;
	private JTextField orderPrice;
	private JTextPane selectedItems;
	private JButton completeOrder;
	private JButton clearOrder;

	public OrderView()
	{
		listOfItemButtons = new ArrayList<>();
		create();

		setSize(1500,1500);
		setTitle("Order Management System");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public List<JButton> getListOfItemButtons()
	{
		return listOfItemButtons;
	}

	public JButton getCompleteOrderButton()
	{
		return completeOrder;
	}

	public JButton getClearOrderButton()
	{
		return clearOrder;
	}

	private void create()
	{
		JPanel mainPanel = (JPanel) getContentPane();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createItemButtonPanel(), createReceiptPanel());
		splitPane.setDividerLocation(780);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(splitPane, BorderLayout.CENTER);
	} 

	private JScrollPane createItemButtonPanel()
	{
		itemButtonPanel = new JPanel();
		itemButtonPanel.setLayout(new GridLayout(0,3));

		JScrollPane scroller = new JScrollPane(itemButtonPanel);
		Border etchedBorder = BorderFactory.createEtchedBorder();
		Border border = BorderFactory.createTitledBorder(etchedBorder, "Items",TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lucida", Font.BOLD, 20) , Color.BLACK);
		itemButtonPanel.setBorder(border);

		return scroller;
	}

	private JPanel createReceiptPanel()
	{
		receipt = new JPanel();
		JLabel label = new JLabel("Customer Order:");
		receipt.setLayout(new BorderLayout());

		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout());

		receipt.add(lowerPanel, BorderLayout.SOUTH);
		receipt.add(label, BorderLayout.NORTH);

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,1));

		selectedItems = new JTextPane();
		centerPanel.add(selectedItems);
		selectedItems.setEditable(false);

		JScrollPane centerPanelScroller = new JScrollPane(centerPanel);
		receipt.add(centerPanelScroller, BorderLayout.CENTER);

		orderPrice = new JTextField(20);
		orderPrice.setText("Total Cost = RM0.00");
		orderPrice.setEditable(false);

		completeOrder = new JButton("Complete Order");
		clearOrder = new JButton("Clear Order");

		completeOrder.setPreferredSize(new Dimension(30,50));
		clearOrder.setPreferredSize(new Dimension(30,50));

		centerPanel.setBackground(Color.LIGHT_GRAY);
		completeOrder.setForeground(Color.BLUE);
		clearOrder.setForeground(Color.RED);

		completeOrder.setFont(new Font ("Times New Roman", Font.BOLD,40));
		clearOrder.setFont(new Font ("Times New Roman", Font.BOLD,40));

		lowerPanel.add(orderPrice, BorderLayout.NORTH);
		lowerPanel.add(completeOrder, BorderLayout.CENTER);
		lowerPanel.add(clearOrder, BorderLayout.SOUTH);
		lowerPanel.setBackground(Color.LIGHT_GRAY);
		receipt.setBackground(Color.WHITE);
		return receipt;
	}

	public void updateItemButtons(FoodMap itemButtons)
	{
		for (final FoodItem itemButton: itemButtons.getMap().keySet())
		{
			final JButton createButton = new JButton(itemButton.getName());
			createButton.setToolTipText(itemButton.toString());

			itemButtonPanel.add(createButton);
			createButton.setPreferredSize(new Dimension(30,20));
			listOfItemButtons.add(createButton);
		}
		revalidate();
		repaint();
	}

	public void clearSelectedItems()
	{
		orderPrice.setText("Total Cost = RM0.00");
		selectedItems.setText(null);
	}

	public void refreshPanel(final FoodItem food, final FoodMap order)
	{
		BigDecimal totalPrice = order.getPrice().setScale(2);
		String foodItemsInformation = order.toString();

		selectedItems.setText(foodItemsInformation);
		orderPrice.setText("Total Cost = RM" + totalPrice);
	}
}