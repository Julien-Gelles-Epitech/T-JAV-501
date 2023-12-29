package main;

import sprite.Sprite;

import javax.swing.*;
import javax.sound.sampled.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FontFormatException {
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(1280, 720);

        dialog.setLayout(new BorderLayout());

        JPanel background = new JPanel();
        background.setBackground(Color.BLACK);
        background.setLayout(new GridBagLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("2D GAME", SwingConstants.CENTER);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/Minecraft.ttf")).deriveFont(30f);
        Font customFontBtn = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/Minecraft.ttf")).deriveFont(20f);
        titleLabel.setFont(customFont);
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);


        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel imageLabel1 = new JLabel(new ImageIcon("res/player2/skeletonTitle.png"));
        imagePanel.add(imageLabel1);

        JLabel imageLabel2 = new JLabel(new ImageIcon("res/player/zombieTitle.png"));
        imagePanel.add(imageLabel2);

        centerPanel.add(titlePanel);
        centerPanel.add(imagePanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        background.add(centerPanel, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton playButton = new JButton("Play");
        customizeButton(playButton);


        playButton.setFont(customFontBtn);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                launchGame();
                playMusic("res/audio/music.wav");
            }
        });
        buttonPanel.add(playButton);

        JButton quitButton = new JButton("Quit");
        customizeButton(quitButton);
        quitButton.setFont(customFontBtn);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(quitButton);
        gbc.gridy = 1;
        background.add(buttonPanel, gbc);
        dialog.add(background);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void gameOver(String dead, String imgSprite) throws IOException, FontFormatException {
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(1280, 720);

        dialog.setLayout(new BorderLayout());

        JPanel background = new JPanel();
        background.setBackground(Color.BLACK);
        background.setLayout(new GridBagLayout());
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/Minecraft.ttf")).deriveFont(30f);
        Font customFontBtn = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/Minecraft.ttf")).deriveFont(20f);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel deathMessageLabel = new JLabel("Le " + dead + " est mort ", SwingConstants.CENTER);
        deathMessageLabel.setFont(customFont);
        deathMessageLabel.setForeground(Color.WHITE);
        centerPanel.add(deathMessageLabel);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel deadImageLabel = new JLabel(new ImageIcon(Sprite.getSprite(5, 20, imgSprite)));
        imagePanel.add(deadImageLabel);

        centerPanel.add(titlePanel);
        centerPanel.add(imagePanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        background.add(centerPanel, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton restartButton = new JButton("Rejouer");
        customizeButton(restartButton);
        restartButton.setFont(customFontBtn);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                launchGame();
            }
        });
        buttonPanel.add(restartButton);

        JButton quitButton = new JButton("Quit");
        customizeButton(quitButton);
        quitButton.setFont(customFontBtn);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(quitButton);


        gbc.gridy = 1;
        background.add(buttonPanel, gbc);
        dialog.add(background);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }


    private static void customizeButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.DARK_GRAY);
            }
        });

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.BLACK);
            }
        });



        button.setUI(new BasicButtonUI() {
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
            }
        });
    }

    public static void launchGame() {
        JFrame window = new JFrame("2D game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.launchGame();
    }

    public static void playMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}