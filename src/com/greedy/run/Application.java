package com.greedy.run;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Application {
		static int com;
	public static void main(String[] args) {
		// 가위바위보 프레임 (600 x 600)
		JFrame mf = new JFrame("가위 바위 보 게임");
		mf.setSize(600, 600);
		/* 이미지 객체 생성 및 초기화 
		 * 
		 * 1. 가위바위보 이미지 
		 * 2. 가위 이미지
		 * 3. 바위 이미지
		 * 4. 보 이미지
		 * 5. 컴퓨터의 가위바위보 이미지
		 * */
		
		Image gawebawebo = new ImageIcon(
				"images/gawebawebo.png").getImage().getScaledInstance(300, 100, 0);
		
		Image gaweImage = new ImageIcon("images/gawe.jpg"
				).getImage().getScaledInstance(50, 50, 0); 
		
		Image baweImage = new ImageIcon("images/bawe.jpg"
				).getImage().getScaledInstance(50, 50, 0); 
		
		Image boImage = new ImageIcon("images/bo.jpg"
				).getImage().getScaledInstance(50, 50, 0); 
		
		Image comGawebawebo = new ImageIcon("images/init.png"
				).getImage().getScaledInstance(100, 100, 0); 
		
		// 가위 바위보 이미지 라벨 생성
		JLabel gawebaweboLabel = new JLabel(new ImageIcon(gawebawebo));
		
		// 결과 화면을 구성할 패널 생성(GridLayout(3,1))
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout(3,1));
		
		// 컴퓨터의 가위바위보 이미지라벨 생성
		JLabel resultLabelImage = new JLabel(new ImageIcon(comGawebawebo));
		
		// 가위바위보 승부를 알려줄 라벨 생성 
		// SwingConstants.CENTER 는 라벨의 텍스트를 가운데 정렬하는 값입니다.
		JLabel resultLabel = new JLabel("가위바위보!", SwingConstants.CENTER);

		/* resultPanel에 추가
		 * 1. computer 라벨
		 * 2. 라벨이미지
		 * 3. 결과 라벨 
		 * */
		resultPanel.add(new JLabel("computer", SwingConstants.CENTER));
		resultPanel.add(resultLabelImage);
		resultPanel.add(resultLabel);
		
		// 가위, 바위, 보 패널 추가하기 (GridLayout(2, 1))
		// 가위 패널 생성 및 레이아웃 설정
		JPanel gawePanel = new JPanel();
		gawePanel.setLayout(new GridLayout(2, 1));
		// 라벨 이미지를 받을 이미지 라벨 생성 및 설정
		JLabel gaweLabel = new JLabel(new ImageIcon());
		gaweLabel.setIcon(new ImageIcon(gaweImage));
		
		// 바위 
		JPanel bawePanel = new JPanel();
		bawePanel.setLayout(new GridLayout(2, 1));
		
		JLabel baweLabel = new JLabel(new ImageIcon());
		baweLabel.setIcon(new ImageIcon(baweImage));
		
		// 보
		JPanel boPanel = new JPanel();
		boPanel.setLayout(new GridLayout(2, 1));
		
		JLabel boLabel = new JLabel(new ImageIcon());
		boLabel.setIcon(new ImageIcon(boImage));
		
		// 가위 바위 보 버튼 객체 생성
		JButton gawe = new JButton("가위");
		JButton bawe = new JButton("바위");
		JButton bo = new JButton("보");
		
		// 가위가 눌렸을 때
		gawe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1. 결과라벨의 텍스트 값을 이겼는지, 비겼는지, 졌는지 변경
				 * 2. 컴퓨터의 이미지에 따라 다른 이미지객체 생성
				 * 3. 컴퓨터의 이미지라벨 변경
				 * */
				resultLabel.setText(game(1));
				Image comGawebawebo = new ImageIcon(getImage(com)
							).getImage().getScaledInstance(100, 100, 0); 
				resultLabelImage.setIcon(new ImageIcon(comGawebawebo));
			}
		});
		// 바위가 눌렸을 때
		bawe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1. 결과라벨의 텍스트 값을 이겼는지, 비겼는지, 졌는지 변경
				 * 2. 컴퓨터의 이미지에 따라 다른 이미지객체 생성
				 * 3. 컴퓨터의 이미지라벨 변경
				 * */
				resultLabel.setText(game(2));
				Image comGawebawebo = new ImageIcon(getImage(com)
						).getImage().getScaledInstance(100, 100, 0); 
				resultLabelImage.setIcon(new ImageIcon(comGawebawebo));
			}
		});
		// 보가 눌렸을 때
		bo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1. 결과라벨의 텍스트 값을 이겼는지, 비겼는지, 졌는지 변경
				 * 2. 컴퓨터의 이미지에 따라 다른 이미지객체 생성
				 * 3. 컴퓨터의 이미지라벨 변경
				 * */
				resultLabel.setText(game(3));
				Image comGawebawebo = new ImageIcon(getImage(com)
						).getImage().getScaledInstance(100, 100, 0);
				resultLabelImage.setIcon(new ImageIcon(comGawebawebo));
			}
		});
		
		// 가위 패널 채우기
		// 1. 가위패널에 가위 이미지추가
		// 2. 가위 패널에 가위 버튼 추가
		gawePanel.add(gaweLabel);
		gawePanel.add(gawe);
		
		// 바위 패널 채우기
		// 1. 바위패널에 가위 이미지추가
		// 2. 바위 패널에 가위 버튼 추가
		bawePanel.add(baweLabel);
		bawePanel.add(bawe);
		
		// 보 패널 채우기
		// 1. 보 패널에 가위 이미지추가
		// 2. 보 패널에 가위 버튼 추가
		boPanel.add(boLabel);
		boPanel.add(bo);
	
		
		// 게임 패널 객체 생성 및 채우기
		// 레이아웃은 디폴트 값(boarder Layout)
		JPanel gamePanel = new JPanel();
		// 가위 바위 보 순
		gamePanel.add(gawePanel);
		gamePanel.add(bawePanel);
		gamePanel.add(boPanel);
		
		// 프렘임 채우기
		// 가위바위보 이미지라벨 - 위
		// 결과 패널 - 가운데
		// 게임 패널 - 아래
		mf.add(gawebaweboLabel, "North");
		mf.add(resultPanel, "Center");
		mf.add(gamePanel, "South");
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
//	public static String game(int user) {
//
//		// 가위바위보 승부에 따라 결과 값을 반환
//		
//		// com = 1부터 3까지의 난수 생성
//		
//		// com == user "비겼습니다."
//		// user == 1(가위) 일때
//		// com == 3(보) 면 "이겼습니다.", 아니면 "졌습니다."
//		
//	}
//	
//	public static String getImage(int num) {
//		// 입력받은 숫자에 따라 다른 이미지의 이름을 반환하는 함수
//		// 1 = images/gawe.jpg
//		// 2 = images/bawe.jpg
//		// 3 = images/bo.jpg
//		
//	}

}
