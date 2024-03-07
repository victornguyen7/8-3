package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui extends JFrame implements ActionListener{
	private JLabel label;
	private JFrame firstFrame;
	private JFrame secondFrame;
	private JPanel panel;
	private ImageIcon image;
    private ImageIcon imageFlower;
	private JButton button;
	private JTextField textField;
	private JLayeredPane layeredPane;

	public gui() {
		firstFrame = new JFrame();
		panel = new JPanel();
		button = new JButton("Click me");
		button.addActionListener(this);
		label = new JLabel("Click the button");
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250, 40));

		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(label);
		panel.add(textField);
		firstFrame.add(panel, BorderLayout.CENTER);
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstFrame.setTitle("Women's Day");
		firstFrame.pack();
		firstFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    if (secondFrame == null) {
        secondFrame = new JFrame();
        layeredPane = new JLayeredPane();
        try {
            image = new ImageIcon(getClass().getResource("IMG_4118.JPEG"));
            JLabel displayField = new JLabel(image);
            displayField.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
            layeredPane.add(displayField, JLayeredPane.DEFAULT_LAYER);

            int x = 430;

            panel.removeAll();

            JLabel initialLabel = new JLabel("Hello " + textField.getText());
            initialLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            initialLabel.setForeground(Color.black);
            initialLabel.setBackground(Color.white);

            initialLabel.setBounds(x, 129, 200, 50);
            layeredPane.add(initialLabel, JLayeredPane.PALETTE_LAYER);

            JButton secondButton = new JButton("Click me");
            secondButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    initialLabel.setText("Happy Women's Day");
					initialLabel.setBounds(395, 129, 200, 50);
					layeredPane.remove(secondButton);
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            });
            secondButton.setBounds(x, 410, 100, 50);
            layeredPane.add(secondButton, JLayeredPane.MODAL_LAYER);


			JButton thirdButton = new JButton("Click me");
            thirdButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
					initialLabel.setText("<html>Chúc cô gái ở<br>trước màn hình<br>luôn luôn xinh đẹp</html>");
					initialLabel.setBounds(410, 110, 200, 100);
					layeredPane.remove(thirdButton);
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            });
            thirdButton.setBounds(x, 410, 100, 50);
            layeredPane.add(thirdButton, JLayeredPane.MODAL_LAYER);


			JButton fourthButton = new JButton("Click me");
            fourthButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
					initialLabel.setText("<html>luôn luôn hạnh phúc<br>và thành công trên<br>con đường đã chọn.</html>");
					initialLabel.setBounds(400, 110, 200, 100);
					layeredPane.remove(fourthButton);
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            });
            fourthButton.setBounds(x, 410, 100, 50);
            layeredPane.add(fourthButton, JLayeredPane.MODAL_LAYER);

            JButton fifthButton = new JButton("Click me");
            fifthButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the button
                    layeredPane.remove(fifthButton);
                    layeredPane.remove(displayField);
                    initialLabel.setText("Hihihihihi");
					initialLabel.setBounds(100, 100, 200, 100);
                    initialLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
                    initialLabel.setForeground(Color.white);
                    
                    // Load the new image
                    ImageIcon imageFlower = new ImageIcon(getClass().getResource("ce99e8383876d81bdc0712ed79193afe.jpg"));
                    JLabel displayField_2 = new JLabel(imageFlower);
                    displayField_2.setBounds(0, 0, imageFlower.getIconWidth(), imageFlower.getIconHeight());
                    layeredPane.add(displayField_2, JLayeredPane.DEFAULT_LAYER);
                    secondFrame.setSize(imageFlower.getIconWidth(), imageFlower.getIconHeight());


            
                    // Revalidate and repaint the layered pane to reflect changes
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            });
            
            fifthButton.setBounds(x, 410, 100, 50);
            layeredPane.add(fifthButton, JLayeredPane.MODAL_LAYER);

            secondFrame.add(layeredPane, BorderLayout.CENTER);
            secondFrame.setSize(image.getIconWidth(), image.getIconHeight());
            secondFrame.setVisible(true);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        firstFrame.setVisible(false);
    }
}

	public static void main(String[] args) {
		new gui();
	}
}
