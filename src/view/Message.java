package view;

import controller.Controller;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by tahel on 08/03/17.
 */
public class Message extends GuiElement {

    private Controller controller;

    private User dest;

    public Message(Controller controller, User dest) {
        this.controller = controller;
        this.dest = dest;
        initComponents();
    }

    public User getDest() {
        return dest;
    }

    public void setDest(User dest) {
        this.dest = dest;
    }

    @Override
    public void initComponents() {
        this.setTitle("Username - Discussion");
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500,300));

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20,20,20,20));
        panel.setLayout(new BorderLayout());

        JLabel labelDest = new JLabel("Username");
        labelDest.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel imageUser = new JLabel(dest.getIcon());

        JTextArea discussion = new JTextArea();
        discussion.setEditable(false);
        discussion.setRows(20);

        JTextArea sendtext = new JTextArea();
        sendtext.setRows(3);

        JButton send = new JButton("Send");

        JToolBar toolBar = new JToolBar();
        JButton sendEmotes = new JButton("Emotes");
        JButton sendFiles = new JButton("Files");
        toolBar.add(sendEmotes);
        toolBar.add(sendFiles);

        JPanel panel_top = new JPanel();
        panel_top.setLayout(new BorderLayout());

        panel_top.add(imageUser, BorderLayout.NORTH);
        panel_top.add(labelDest, BorderLayout.WEST);
        panel_top.add(discussion, BorderLayout.CENTER);

        JPanel panel_bot = new JPanel();
        panel_bot.setLayout(new BorderLayout());



        panel_bot.add(sendtext, BorderLayout.CENTER);
        panel_bot.add(toolBar, BorderLayout.NORTH);
        panel_bot.add(send, BorderLayout.EAST);



        panel.add(panel_top, BorderLayout.CENTER);
        panel.add(panel_bot, BorderLayout.SOUTH);

        this.add(panel);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Message.super.close();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.pack();
        this.setVisible(false);
    }

    @Override
    public void notif(String msg) {

    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }
        try {
            User user = new User("Coucou", Inet4Address.getLocalHost());

            Message msg = new Message(null, user);

            msg.setVisible(true);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}