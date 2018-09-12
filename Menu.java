package Code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import util.JdbcUtil;


public class Menu implements ActionListener 
{
	// 멤버변수
	JFrame f , pass ;
	private static int[] MenuData = new int[7];
	private static boolean[][] toppingSelecting = new boolean[3][2];
	private static boolean[][] vegetableSelecting = new boolean[3][3];
	private static boolean[][] sauceSelecting = new boolean[3][3];
	ImageIcon[] classicPhoto1, LandFPhoto1 , prePhoto1,  breadPhoto1, topPhoto1, vegePhoto1, saucePhoto1, setPhoto1;
	ImageIcon[] classicPhoto, LandFPhoto , prePhoto,  breadPhoto, topPhoto, vegePhoto, saucePhoto, setPhoto, buttonPhoto ;
	Color choice;

	static int checking = 0;

	static String number;
	JTextArea console;
	JButton[][] menuClassic ,menuLandF ,menuPremium , breadMenu , toppingMenus , vegetableMenus , sauceMenus ,keypad ;
	JPanel p1 , p2 , p3 , p4 ,p11, p22, p33 , menu , bread , breadMenu1 , breadOption , topping , toppingMenu , toppingOption , vegetable , vegetableMenu , vegetableOption , sauce
	,sauceMenu , sauceOption , f2 , password , pSand , pCook;
	JButton  MenuType1 , MenuType2 , MenuType3 , breadToMenu ,breadToAddi , toppingToVege , toppingToBread , vegeToSauce , vegeToAddi
	,sauceTovege , OrderToEnd ,toFresh , toClass , toPre , jb , jb2;

	//세트
	JTextArea ta;//신규
	JTextField tf;//신규
	JLabel endImage, listname,setQuestion,orderSandwich,orderSide;//신규 , orderSandwich,orderSide -> 첨부
	int answer;//신규
	ImageIcon Icon;
	JPanel cokeCookie, card, side, sideMenu, sideOption, order, orderDetail , orderOption, set, setOption1, setOption2; //신규
	JButton cardImage, coke, sideTopay, sideTosauce, setTosauce,setToorder, setYes, setNo, orderTosauce, orderTopay; //신규
	JButton[] cookie; //신규

	String[] allMenu2 = 
		{
				"클래식" , "프레쉬 & 라이트" , "프리미엄"
		};
	String[] ClassicMenu2 =
		{
				"비엘티" , "미트볼" , "이탈리안 비엠티" , "에그마요" , "참치" , "햄"
		};

	String[] FandLMenu2 = 
		{
				"로스트 치킨" , "써브웨이 클럽" , "터키" , " 로스트 비프" , "베지" , "로티세리 치킨"
		};

	String[] PremiumMenu2 =
		{
				"치킨 데리야끼" , "스파이시 이탈리안" , "터키 베이컨" , "써브웨이 멜트" , "치킨 베이컨 랜치" , "폴드포크"
		};

	String[] breadMenu2 =
		{
				"허니 오트" , "하티" , "위트" , "파마산 오레가노" , "플랫브래드" , "화이트"
		};

	String[] cookieMenu2 = 
		{
				"더블 초코칩 쿠키" , "초코칩 쿠키" , "오트밀레이즌" , "라즈베리 치즈케잌" , "화이트 초코 마카다미아"
		};
	String[] toppingMenu2 =
		{
				"에그마요" , "오믈렛" , "아보카도" , "베이컨"      
		};
	String[] VeseMenu2 = 
		{
				"양상추" , "토마토" , "오이" , "피망" , "양파" , "피클" , "올리브", "할리피뇨" , "아보카도"
		};
	String[] sauceMenu2 =
		{
				"랜치드레싱" , "마요네즈" , "스위트 어니언" , "허니 머스타드" , "스위트 칠리", "사우스 웨스트",
				"스모크 바베큐" , "사우전 아일랜드" , "이탈리안 드레싱"
		};

	// 생성자 함수

	public int[] getMenuData() 
	{
		return MenuData;
	}

	public boolean[][] getToppingSelecting()
	{
		return  toppingSelecting;
	}

	public boolean[][] getVegetableSelecting()
	{
		return  vegetableSelecting;
	}

	public boolean[][] getSauceSelecting()
	{
		return  sauceSelecting;
	}

	public Menu() 
	{
		MenuData[4] = -1;
		card = new JPanel();
		cardImage=new JButton();
		endImage =new JLabel();

		side = new JPanel();
		sideMenu = new JPanel();
		sideOption = new JPanel();
		sideTopay = new JButton("다음");
		sideTosauce = new JButton("이전");
		sideMenu.setLayout(new GridLayout(1, 5));
		cookie=new JButton[5];
		coke=new JButton();
		cokeCookie=new JPanel();

		JLabel setQuestion=new JLabel();
		//setQuestion.setFont(new Font("NanumGothic",Font.BOLD, 30));
		set = new JPanel();
		setOption1 = new JPanel();
		setYes=new JButton("예");
		setNo=new JButton("아니오");
		setOption2 = new JPanel();
		setTosauce = new JButton("이전");
		setToorder = new JButton("다음");


		JLabel listname=new JLabel("<주문 확인>");
		//listname.setFont(new Font("NanumGothic", Font.BOLD, 30));
		JLabel orderSandwich= new JLabel("<샌드위치>");
		JLabel orderSide= new JLabel("<사이드>");
		order = new JPanel();
		JTextField tf=new JTextField(30);
		JTextArea ta=new JTextArea(5,20);
		orderTosauce = new JButton("이전");
		orderTopay = new JButton("결제");
		orderOption = new JPanel();
		orderDetail = new JPanel();


		breadMenu = new JButton[2][3];
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				breadMenu[i][j] = new JButton();
				breadMenu[i][j].addActionListener(this);
				breadMenu[i][j].setIcon(new ImageIcon("C:\\java\\workspace\\Advanced\\src\\project\\3.jpg"));
				breadMenu[i][j].setBackground(Color.lightGray);
			}
		}

		sauce = new JPanel();
		sauceMenu = new JPanel();
		sauceOption = new JPanel();
		sauceMenus = new JButton[3][3];
		OrderToEnd = new JButton("다음");
		sauceTovege = new JButton("이전");

		vegetable = new JPanel();
		vegetableMenu = new JPanel();
		vegetableOption = new JPanel();
		vegetableMenus = new JButton[3][3];
		vegeToSauce = new JButton("다음");
		vegeToAddi = new JButton("이전");

		topping = new JPanel();
		toppingMenu = new JPanel();
		toppingOption = new JPanel();
		toppingMenus = new JButton[3][2];
		toppingToVege = new JButton("다음");
		toppingToBread = new JButton("이전");
		toppingSelecting = new boolean[3][2];

		bread = new JPanel();
		breadMenu1 = new JPanel();
		breadOption = new JPanel();
		breadToAddi = new JButton("다음");
		breadToMenu = new JButton("이전");

		classicPhoto = new ImageIcon[6];
		classicPhoto1 = new ImageIcon[6];
		LandFPhoto = new ImageIcon[6];
		LandFPhoto1 = new ImageIcon[6];
		prePhoto = new ImageIcon[6];
		prePhoto1 = new ImageIcon[6];

		breadPhoto = new ImageIcon[6];
		topPhoto  = new ImageIcon[6];
		vegePhoto  = new ImageIcon[9];
		saucePhoto = new ImageIcon[9];  
		setPhoto =  new ImageIcon[6];      // 버튼수 수정
		buttonPhoto = new ImageIcon[10];
		button();

		breadPhoto1 = new ImageIcon[6];
		topPhoto1 = new ImageIcon[6]; 
		vegePhoto1 = new ImageIcon[9];
		saucePhoto1 =new ImageIcon[9];
		setPhoto1 = new ImageIcon[6];         


		addLayout();

		f2 = new JPanel();
		f2.setSize(700,700);
		f2.setLayout(null);
		String imgPathStart = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\start.png";   
		ImageIcon originIconStart = new ImageIcon(imgPathStart);
		Image originImgStart = originIconStart.getImage();
		Image changedImgStart= originImgStart.getScaledInstance(700,700, Image.SCALE_SMOOTH);
		ImageIcon IconStart = new ImageIcon(changedImgStart);
		jb = new JButton(IconStart);
		jb.setSize(700,630);
		f2.add(jb);
		jb2 = new JButton("...");
		jb2.setBackground(Color.white);
		jb2.setBounds(625,640,50,20);
		f2.add(jb2);

		jb.addActionListener(this);
		jb2.addActionListener(this);
		/*		      jb.addActionListener(new ActionListener() {
		        @Override
		         public void actionPerformed(ActionEvent e) {
		           MenuStart();
		         }
		      });

		      jb2.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		                Password();*/


		f.add(f2);

		f.setVisible(true);

	}

	ImageIcon[] button()
	{
		int count =10;
		for ( int i = 0; i < count; i++)
		{
			String[] imgPath = new String[count];
			ImageIcon[] originIcon = new ImageIcon[count];
			ImageIcon[] Icon = new ImageIcon[count];
			Image[] originImg = new Image[count];
			Image[] changedImg = new Image[count];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\arrow\\"+i+".png";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(120,50, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);

			buttonPhoto[i] = Icon[i];   
		}

		return buttonPhoto;
	}

	void MenuStart()
	{
		f.remove(f2);
		f.setLayout(new BorderLayout());
		f.setVisible(false);
		MenuType1 = new JButton("                 Classic                ");
		MenuType2 = new JButton("            Light & Fresh             ");
		MenuType3 = new JButton("                Premium                ");

		MenuType1 = new JButton(buttonPhoto[2]);	MenuType1.setPreferredSize(new Dimension(150,55));
		MenuType2 = new JButton(buttonPhoto[3]);	MenuType2.setPreferredSize(new Dimension(150,55));
		MenuType3 = new JButton(buttonPhoto[4]);	MenuType3.setPreferredSize(new Dimension(150,55));

		MenuType1.setBackground(Color.WHITE);	MenuType1.setBorder(BorderFactory.createEmptyBorder ());
		MenuType2.setBackground(Color.WHITE);	MenuType2.setBorder(BorderFactory.createEmptyBorder ());
		MenuType3.setBackground(Color.WHITE);	MenuType3.setBorder(BorderFactory.createEmptyBorder ());

		menu = new JPanel();
		menuClassic = new JButton[2][3];
		menuLandF = new JButton[2][3];
		menuPremium = new JButton[2][3];

		MenuType1.addActionListener(this);
		MenuType2.addActionListener(this);
		MenuType3.addActionListener(this);

		p1 = new JPanel();
		p11 = new JPanel();
		p2 = new JPanel();
		p22 = new JPanel();
		p3 = new JPanel();
		p33 = new JPanel();
		p4 = new JPanel();

		p4.setLayout(new FlowLayout());
		p4.setBackground(Color.white);

		MenuType1.setSize(10,100);
		MenuType2.setSize(10,100);
		MenuType3.setSize(10,100);

		p4.add(MenuType1 );
		p4.add(MenuType2 );
		p4.add(MenuType3 );

		p1.setLayout(new GridLayout(2,3));
		p2.setLayout(new GridLayout(2,3));
		p3.setLayout(new GridLayout(2,3));

		menu.setLayout(new BorderLayout());
		menu.add(p4 , BorderLayout.NORTH);

		f.add(menu);
		f.setVisible(true);
	}


	void addLayout() 
	{
		f = new JFrame("메뉴");
		f.setResizable(false);
		f.setVisible(false);
		f.setLayout(null);
		f.setSize(700, 700);
		//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버튼
	}

	public void Password()
	{
		checking +=1;
		number = "";
		pass = new JFrame("비밀번호");
		pass.setResizable(false);
		pass.setLayout(null);
		pass.setSize(330, 280);
		pass.setVisible(true);
		//		pass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		console = new JTextArea();
		console.setSize(250,20);
		password = new JPanel();
		password.setLayout(null);
		password.setSize(300,200);
		password.setLayout(new GridLayout(3, 3));
		keypad = new JButton[3][3];
		for (int i = 0; i <3; i++)
		{
			for (int j = 0; j <3; j++) 
			{
				int temp = 3*i+j + 1;
				keypad[i][j] = new JButton(Integer.toString(temp));
				keypad[i][j].addActionListener(this);
				password.add(keypad[i][j]);
			}
		}
		pass.add(console);
		pass.add(password);

		console.setLocation(35, 5);
		password.setLocation(10, 50);

		pass.setVisible(true);


	}

	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton) e.getSource();
		if (btn == jb)
		{
			MenuStart();
		}
		else if (btn == jb2)
		{
			Password();
		}

		else if(checking != 0)
		{
			for (int i = 0; i < 3; i++) 
			{
				for (int j = 0; j < 3; j++) 
				{
					if (btn == keypad[i][j]) 
					{
						console.setText(console.getText() + Integer.toString(3*i+j+1));
						number = number + Integer.toString(3*i+j+1);
						if (number.equals("1234"))
						{
							f.setVisible(false);
							pass.setVisible(false);
						}
					}
				}
			}
		}

		else if (btn == MenuType1)
		{    	  
			if(MenuData[0] != 0)
			{
				MenuType1.setBackground(Color.white);
				MenuType1.setIcon(buttonPhoto[2]); 
			}
			else
			{
				MenuType1.setBackground(Color.blue);
				MenuType1.setIcon(buttonPhoto[5]);
			}
			MenuData[0] = 0;
			selectClassic();


		}
		else if (btn == MenuType2)
		{
			if(MenuData[0] != 1)
			{
				MenuType2.setBackground(Color.white);
				MenuType2.setIcon(buttonPhoto[3]); 
			}
			else
			{
				MenuType2.setBackground(Color.blue);
				MenuType2.setIcon(buttonPhoto[5]);
			}
			MenuData[0] = 1;
			selecLanF();
		}

		else if (btn == MenuType3)
		{

			if(MenuData[0] != 2)
			{
				MenuType3.setBackground(Color.white);
				MenuType3.setIcon(buttonPhoto[4]); 
			}else
			{
				MenuType3.setBackground(Color.blue);
				MenuType3.setIcon(buttonPhoto[7]);
			}
			MenuData[0] = 2;
			selectPre();
		}
		else 
		{
			for (int i = 0; i < 2; i++)
			{
				for (int j = 0; j < 3; j++) 
				{
					if( btn == menuClassic[i][j])
					{
						for (int k = 0; k < 2; k++) 
						{
							for (int p = 0; p < 3; p++) 
							{
								menuClassic[k][p].setBackground(Color.white);     //for문안에 있어야  중복으로 선택이 안됨
								menuClassic[k][p].setIcon(classicPhoto[3*k+p]);      //사진도 중복선택안되게
							}
						} 

						MenuData[1] =3*i + j;
						menuClassic[i][j].setIcon(classicPhoto1[3*i+j]);
						menuClassic[i][j].setBackground(choice);
						Timer timer = new Timer();
						TimerTask task = new TimerTask() 
						{ 
							public void run() 
							{
								selectbread();
							}
						}; 
						timer.schedule(task, 200);
					}

					else if (btn == menuLandF[i][j])   //프레쉬 메뉴를 고르면
					{
						for (int k = 0; k < 2; k++) 
						{
							for (int p = 0; p < 3; p++) 
							{
								menuLandF[k][p].setBackground(Color.white);     //for문안에 있어야  중복으로 선택이 안됨
								menuLandF[k][p].setIcon(LandFPhoto[3*k+p]);      //사진도 중복선택안되게                         
							}
						}             	    
						MenuData[1] =3*i + j;
						menuLandF[i][j].setIcon(LandFPhoto[3*i+j]);
						menuLandF[i][j].setBackground(choice);
						Timer timer = new Timer();
						TimerTask task = new TimerTask() 
						{ 
							public void run() 
							{
								selectbread();
							}
						}; 
						timer.schedule(task, 200);
					}

					else if (btn == menuPremium[i][j])    //프리미엄 메뉴를 고르면
					{
						for (int k = 0; k < 2; k++) 
						{
							for (int p = 0; p < 3; p++) 
							{
								menuPremium[k][p].setBackground(Color.white);     //for문안에 있어야  중복으로 선택이 안됨
								menuPremium[k][p].setIcon(prePhoto[3*k+p]);      //사진도 중복선택안되게                         
							}
						}     
						MenuData[1] =3*i + j;
						menuPremium[i][j].setIcon(prePhoto1[3*i+j]);
						menuPremium[i][j].setBackground(choice);
						Timer timer = new Timer();
						TimerTask task = new TimerTask() 
						{ 
							public void run()
							{
								selectbread();
							}
						}; 
						timer.schedule(task, 200);
					}
				}
			}


			for (int i = 0; i < 2; i++) 
			{
				for (int j = 0; j < 3; j++) 
				{
					if ( btn == breadMenu[i][j])
					{
						for (int k = 0; k < 2; k++) 
						{
							for (int p = 0; p < 3; p++) 
							{
								breadMenu[k][p].setBackground(Color.white);     //for문안에 있어야  중복으로 선택이 안됨
								breadMenu[k][p].setIcon(breadPhoto[3*k+p]);      //사진도 중복선택안되게

							}
						} 
						MenuData[2] =3*i + j;
						breadMenu[i][j].setIcon(breadPhoto1[MenuData[2]]); //선택됐을때 변화
						breadMenu[i][j].setBackground(choice);
						break;                  
					}  
				}
			}

			for (int i = 0; i < 3; i++) 
			{
				for (int j = 0; j < 2 ; j++) 
				{
					if ( btn == toppingMenus[i][j])
					{
						if (i == 0)
						{                         
							for (int p = 0; p < 2; p++) 
							{
								toppingMenus[i][p].setBackground(Color.white);     //for문안에 있어야  중복으로 선택이 안됨
								toppingMenus[i][p].setIcon(topPhoto[2*i+p]);      //사진도 중복선택안되게
							}
							//버튼 누르면 이케됌
							MenuData[3] = 2*i + j;
							toppingMenus[i][j].setBackground(choice);     //for문안에 있어야  중복으로 선택이 안됨
							toppingMenus[i][j].setIcon(topPhoto1[2*i+j]);      //사진도 중복선택안되게           

						}
						else
						{
							if (toppingSelecting[i][j])  //두번누르면  == 취소?
							{
								toppingMenus[i][j].setBackground(Color.white);
								toppingSelecting[i][j] = !toppingSelecting[i][j];
								toppingMenus[i][j].setIcon(topPhoto[2*i+j]);
							}
							else       //한 번 누르면
							{
								toppingMenus[i][j].setBackground(choice);
								toppingSelecting[i][j] = !toppingSelecting[i][j];
								toppingMenus[i][j].setIcon(topPhoto1[2*i+j]);
							}                    
						}
					}
				}
			}

			for (int i = 0; i < 3; i++) 
			{
				for (int j = 0; j < 3 ; j++) 
				{
					if ( btn == vegetableMenus[i][j])
					{
						if (vegetableSelecting[i][j]) 
						{
							vegetableMenus[i][j].setBackground(Color.white);
							vegetableSelecting[i][j] = !vegetableSelecting[i][j];
							vegetableMenus[i][j].setIcon(vegePhoto[3*i+j]);
						}
						else
						{
							vegetableMenus[i][j].setBackground(choice);
							vegetableSelecting[i][j] = !vegetableSelecting[i][j];
							vegetableMenus[i][j].setIcon(vegePhoto1[3*i+j]);
						}
					}
				}
			}

			for (int i = 0; i < 3; i++) 
			{
				for (int j = 0; j < 3 ; j++) 
				{
					if ( btn == sauceMenus[i][j])
					{
						if (sauceSelecting[i][j]) 
						{
							sauceMenus[i][j].setBackground(Color.white);
							sauceMenus[i][j].setIcon(saucePhoto[3*i+j]);
							sauceSelecting[i][j] = !sauceSelecting[i][j];

						}
						else
						{
							sauceMenus[i][j].setBackground(choice);
							sauceSelecting[i][j] = !sauceSelecting[i][j];
							sauceMenus[i][j].setIcon(saucePhoto1[3*i+j]);
						}
					}
				}
			}
			/////////////////////////여기부터
			if ( btn == coke)//coke버튼이 눌리면
			{
				MenuData[3] =0; //  MenuData[3]=0 삽입 , 단일제품
				coke.setBackground(Color.darkGray);
			}


			for (int i = 0; i < 5; i++) 
			{
				if ( btn == cookie[i])//cookieSelecting
				{
					for (int k = 0; k < 5; k++) //0~4까지
					{
						// = new boolean[5];
						cookie[k].setBackground(Color.lightGray);
					}

					MenuData[4] =i;// cookie[i] 버튼이 눌리면 MenuData[4]=i 삽입
					cookie[i].setBackground(Color.darkGray);
					break;
				}
			}
			///////////////////////////////여기까지
			if (btn == breadToMenu)
			{
				f.remove(bread);
				f.setVisible(false);
				f.add(menu);
				f.setVisible(true);
			}

			else if (btn == toppingToBread)
			{
				f.remove(topping);
				selectbread();
			}
			else if(btn == breadToAddi)
			{
				selectAdditionalTopping();
			}

			else if (btn ==vegeToAddi)
			{
				f.remove(vegetable);
				selectAdditionalTopping();
			}
			else if (btn == toppingToVege)
			{
				selectvegetable();
			}
			else if (btn == vegeToSauce)
			{
				selectSauce();
			}
			else if (btn == sauceTovege)
			{
				f.remove(sauce);
				selectvegetable();
			}

			if (btn == OrderToEnd)
			{
				int set= selectSet();
				if(set==0) 
				{
					// 0 - 예 : 세트를 선택하면 쿠키,음료 선택화면으로
					f.remove(sauce);
					selectSide();
				}

				else if(set==1) 
				{
					// 0 - 아니오 : 세트를 선택하지 않으면 주문확인 화면으로
					f.remove(sauce);
					orderlist();
				}
			}

			else if(btn == sideTosauce)
			{
				f.remove(side);
				selectSauce();
			}
			else if(btn == sideTopay)
			{
				f.remove(side);
				orderlist();
			}
			else if(btn == orderTosauce)
			{
				f.remove(order);
				selectSauce();
			}
			else if(btn ==cardImage)
			{
				OrderEnd();
			}
			else if(btn ==orderTopay)
			{
				sqlTest();
				Timer timer1 = new Timer();
				TimerTask task1 = new TimerTask() 
				{ 
					public void run() 
					{
						f.setVisible(false);
						JOptionPane.showMessageDialog(null, "결제가 완료되었습니다");
					}
				}; 
				timer1.schedule(task1, 1000);


				Timer timer2 = new Timer();
				TimerTask task2 = new TimerTask() 
				{ 
					public void run() 
					{
						Menu g = new Menu();
					}
				}; 
				timer2.schedule(task2, 1000);
			}
		}
	}



	void selectClassic()
	{
		menu.remove(p11);
		p11 = new JPanel();
		//컬러
		for ( int i = 0; i < classicPhoto.length; i++)
		{
			String[] imgPath = new String[classicPhoto.length];
			ImageIcon[] originIcon = new ImageIcon[classicPhoto.length];
			ImageIcon[] Icon = new ImageIcon[classicPhoto.length];
			Image[] originImg = new Image[classicPhoto.length];
			Image[] changedImg = new Image[classicPhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\menu\\classic\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,200, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			classicPhoto[i] = Icon[i];
		}

		//흑백
		for ( int i = 0; i < classicPhoto1.length; i++)
		{
			String[] imgPath = new String[classicPhoto.length];
			ImageIcon[] originIcon = new ImageIcon[classicPhoto.length];
			ImageIcon[] Icon = new ImageIcon[classicPhoto.length];
			Image[] originImg = new Image[classicPhoto.length];
			Image[] changedImg = new Image[classicPhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\menu\\classic1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(180,180, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			classicPhoto1[i] = Icon[i];   
		}

		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 3; j++) 
			{
				menuClassic[i][j] = new JButton(classicPhoto[3*i+j]);
				menuClassic[i][j].addActionListener(this);
				menuClassic[i][j].setPreferredSize(new Dimension(220,250));       //버튼 크기 조정 
				menuClassic[i][j].setBackground(Color.white);
				//menuClassic[i][j].setBorder(BorderFactory.createEmptyBorder ());  //버튼 테두리 제거
				p11.add(menuClassic[i][j]);
			}

		}
		menu.remove(p22);
		menu.remove(p33);
		p11.setBackground(Color.white);
		menu.add(p11);         //setVisible뒤에 써야    , BorderLayout.CENTER
		f.setVisible(false);
		f.add(menu);
		f.setVisible(true);
	}


	void selecLanF()
	{
		menu.remove(p22);
		p22 = new JPanel();
		p22.setLayout(new FlowLayout());
		//컬러
		for ( int i = 0; i < LandFPhoto.length; i++)
		{
			String[] imgPath = new String[LandFPhoto.length];
			ImageIcon[] originIcon = new ImageIcon[LandFPhoto.length];
			ImageIcon[] Icon = new ImageIcon[LandFPhoto.length];
			Image[] originImg = new Image[LandFPhoto.length];
			Image[] changedImg = new Image[LandFPhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\menu\\fresh\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,200, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			LandFPhoto[i] = Icon[i];   
		}

		//흑백
		for ( int i = 0; i < LandFPhoto1.length; i++)
		{
			String[] imgPath = new String[LandFPhoto1.length];
			ImageIcon[] originIcon = new ImageIcon[LandFPhoto1.length];
			ImageIcon[] Icon = new ImageIcon[LandFPhoto1.length];
			Image[] originImg = new Image[LandFPhoto1.length];
			Image[] changedImg = new Image[LandFPhoto1.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\menu\\fresh1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,200, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			LandFPhoto1[i] = Icon[i];   
		}

		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 3; j++) 
			{
				menuLandF[i][j] = new JButton(LandFPhoto[3*i+j]);
				menuLandF[i][j].addActionListener(this);
				menuLandF[i][j].setPreferredSize(new Dimension(220,250));       //버튼 크기 조정 
				menuLandF[i][j].setBackground(Color.white);
				p22.add(menuLandF[i][j]);
			}
		}
		menu.remove(p33);
		menu.remove(p11);
		menu.add(p22 , BorderLayout.CENTER);
		f.setVisible(false);
		f.add(menu);
		f.setVisible(true);
	}
	void selectPre()
	{
		menu.remove(p33);
		p33 = new JPanel();
		p33.setLayout(new FlowLayout());
		//컬러
		for ( int i = 0; i < prePhoto.length; i++)
		{
			String[] imgPath = new String[prePhoto.length];
			ImageIcon[] originIcon = new ImageIcon[prePhoto.length];
			ImageIcon[] Icon = new ImageIcon[prePhoto.length];
			Image[] originImg = new Image[prePhoto.length];
			Image[] changedImg = new Image[prePhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\menu\\premium\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(210,240, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			prePhoto[i] = Icon[i];   
		}

		//흑백
		for ( int i = 0; i < prePhoto1.length; i++)
		{
			String[] imgPath = new String[prePhoto1.length];
			ImageIcon[] originIcon = new ImageIcon[prePhoto1.length];
			ImageIcon[] Icon = new ImageIcon[prePhoto1.length];
			Image[] originImg = new Image[prePhoto1.length];
			Image[] changedImg = new Image[prePhoto1.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\menu\\premium1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,210, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			prePhoto1[i] = Icon[i];   
		}

		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 3; j++) 
			{
				menuPremium[i][j] = new JButton(prePhoto[3*i+j]);
				menuPremium[i][j].addActionListener(this);
				menuPremium[i][j].setPreferredSize(new Dimension(220,250));       //버튼 크기 조정 
				menuPremium[i][j].setBackground(Color.white);
				p33.add(menuPremium[i][j]);
			}

		}
		menu.remove(p22);
		menu.remove(p11);
		menu.add(p33 , BorderLayout.CENTER);
		f.setVisible(false);
		f.add(menu);
		f.setVisible(true);   
	}

	void selectbread()
	{
		bread = new JPanel();
		breadMenu1 = new JPanel();	  
		f.remove(menu);
		f.setVisible(false);
		bread.setLayout(new BorderLayout());
		breadMenu1.setBackground(Color.WHITE);

		//화면하단
		breadOption = new JPanel();
		breadOption.setLayout(new BorderLayout());
		breadOption.setBackground(Color.white);
		breadToAddi = new JButton(buttonPhoto[0]);
		breadToAddi.setBackground(Color.white);
		//breadToAddi.setBorder(BorderFactory.createEmptyBorder());
		breadToMenu = new JButton(buttonPhoto[1]);
		breadToMenu.setBackground(Color.white);
		breadToMenu.setBorder(BorderFactory.createEmptyBorder());
		breadOption.add(breadToMenu, BorderLayout.WEST);
		breadOption.add(breadToAddi,BorderLayout.EAST);      
		breadToMenu.addActionListener(this);
		breadToAddi.addActionListener(this);

		//컬러
		for ( int i = 0; i < breadPhoto.length; i++)
		{
			String[] imgPath = new String[breadPhoto.length];
			ImageIcon[] originIcon = new ImageIcon[breadPhoto.length];
			ImageIcon[] Icon = new ImageIcon[breadPhoto.length];
			Image[] originImg = new Image[breadPhoto.length];
			Image[] changedImg = new Image[breadPhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\bread\\bread\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(180,180, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			breadPhoto[i] = Icon[i];   
		}

		//흑백
		for ( int i = 0; i < breadPhoto1.length; i++)
		{
			String[] imgPath = new String[breadPhoto1.length];
			ImageIcon[] originIcon = new ImageIcon[breadPhoto1.length];
			ImageIcon[] Icon = new ImageIcon[breadPhoto1.length];
			Image[] originImg = new Image[breadPhoto1.length];
			Image[] changedImg = new Image[breadPhoto1.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\bread\\bread1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,200, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			breadPhoto1[i] = Icon[i];   
		}

		breadMenu = new JButton[2][3];
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				breadMenu[i][j] = new JButton(breadPhoto[3*i+j]);
				breadMenu1.add(breadMenu[i][j]);
				breadMenu[i][j].addActionListener(this);
				breadMenu[i][j].setBackground(Color.white);
				breadMenu[i][j].setPreferredSize(new Dimension(220,220));
			}
		}

		bread.add(breadMenu1, BorderLayout.CENTER);//, BorderLayout.CENTER
		bread.add(breadOption, BorderLayout.SOUTH);//, BorderLayout.SOUTH
		f.add(bread , BorderLayout.CENTER);
		f.setVisible(true);
	}

	void selectAdditionalTopping()
	{
		topping = new JPanel();
		toppingMenu = new JPanel();
		//toppingMenu.setLayout(new BorderLayout());
		//toppingMenu.setLayout(new GridLayout(4,2));
		topping.setBackground(Color.white);
		toppingMenu.setBackground(Color.white);

		topping.setLayout(new BorderLayout());
		f.remove(bread);
		f.setVisible(false);
		//화면하단
		toppingOption = new JPanel();
		toppingOption.setLayout(new BorderLayout());
		toppingOption.setBackground(Color.white);
		toppingToVege = new JButton(buttonPhoto[0]);
		toppingToVege.setBackground(Color.white);
		toppingToVege.setBorder(BorderFactory.createEmptyBorder());
		toppingToBread = new JButton(buttonPhoto[1]);
		toppingToBread.setBackground(Color.white);
		toppingToBread.setBorder(BorderFactory.createEmptyBorder());
		toppingOption.add(toppingToBread, BorderLayout.WEST);
		toppingOption.add(toppingToVege,BorderLayout.EAST);      
		toppingToBread.addActionListener(this);
		toppingToVege.addActionListener(this);

		//컬러
		for ( int i = 0; i < topPhoto.length; i++)
		{
			String[] imgPath = new String[topPhoto.length];
			ImageIcon[] originIcon = new ImageIcon[topPhoto.length];
			ImageIcon[] Icon = new ImageIcon[topPhoto.length];
			Image[] originImg = new Image[topPhoto.length];
			Image[] changedImg = new Image[topPhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\topping\\topping\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,150, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			topPhoto[i] = Icon[i];   
		}

		//흑백
		for ( int i = 0; i < topPhoto1.length; i++)
		{
			String[] imgPath = new String[topPhoto1.length];
			ImageIcon[] originIcon = new ImageIcon[topPhoto1.length];
			ImageIcon[] Icon = new ImageIcon[topPhoto1.length];
			Image[] originImg = new Image[topPhoto1.length];
			Image[] changedImg = new Image[topPhoto1.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\topping\\topping1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,170, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			topPhoto1[i] = Icon[i];   
		}

		//상단 사진
		String imgPath = "C:\\Java\\workspace\\Final\\src\\project\\topping\\0.png";;
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(400,35, Image.SCALE_SMOOTH);
		ImageIcon up0 = new ImageIcon(changedImg);

		String imgPath1 = "C:\\Java\\workspace\\Final\\src\\project\\topping\\1.png";;
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(500,35, Image.SCALE_SMOOTH);
		ImageIcon up1 = new ImageIcon(changedImg1);


		toppingMenus = new JButton[3][2];

		JPanel cheese = new JPanel();
		//cheese.setLayout(new BorderLayout());
		JLabel chee = new JLabel(up0);
		chee.setBounds(30, 205, 600, 100);
		toppingMenu.add(chee);
		cheese.setLayout(new GridLayout(1,2));

		JPanel adtop = new JPanel();
		adtop.setLayout(new BorderLayout());
		JLabel top = new JLabel(up1);

		adtop.setBackground(Color.yellow);
		adtop.setLayout(new GridLayout(2,2));

		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 2; j++) 
			{
				toppingMenus[i][j] = new JButton(topPhoto[2*i+j]);
				if ( i == 0 )
				{
					MenuData[6] = j;
					toppingMenus[i][j].setBorder (BorderFactory.createEmptyBorder ());
					cheese.add(toppingMenus[i][j]);  //,BorderLayout.CENTER
					toppingMenu.add(cheese,BorderLayout.NORTH);
				}
				else
				{
					toppingMenu.add(top);
					adtop.add(toppingMenus[i][j],BorderLayout.SOUTH);
					toppingMenu.add(adtop, BorderLayout.CENTER);
				}
				toppingMenus[i][j].addActionListener(this);
				toppingMenus[i][j].setBackground(Color.white);
				toppingMenus[i][j].setPreferredSize(new Dimension(220,160));            
			}
		} 

		topping.add(toppingMenu, BorderLayout.CENTER); //, BorderLayout.CENTER
		topping.add(toppingOption, BorderLayout.SOUTH ); 
		f.add(topping , BorderLayout.CENTER);
		f.setVisible(true);
	}


	void selectvegetable()
	{
		vegetable = new JPanel();
		vegetableMenu = new JPanel();
		f.remove(topping);
		f.setVisible(false);
		vegetable.setLayout(new BorderLayout());
		vegetableMenu.setBackground(Color.white);

		//화면하단
		vegetableOption = new JPanel();
		vegetableOption = new JPanel();
		vegetableOption.setLayout(new BorderLayout());
		vegetableOption.setBackground(Color.white);
		vegeToSauce = new JButton(buttonPhoto[0]);
		vegeToSauce.setBackground(Color.white);
		vegeToSauce.setBorder(BorderFactory.createEmptyBorder());
		vegeToAddi = new JButton(buttonPhoto[1]);
		vegeToAddi.setBackground(Color.white);
		vegeToAddi.setBorder(BorderFactory.createEmptyBorder());
		vegetableOption.add(vegeToAddi, BorderLayout.WEST);
		vegetableOption.add(vegeToSauce,BorderLayout.EAST);      
		vegeToAddi.addActionListener(this);
		vegeToSauce.addActionListener(this);


		//컬러
		for ( int i = 0; i < vegePhoto.length; i++)
		{
			String[] imgPath = new String[vegePhoto.length];
			ImageIcon[] originIcon = new ImageIcon[vegePhoto.length];
			ImageIcon[] Icon = new ImageIcon[vegePhoto.length];
			Image[] originImg = new Image[vegePhoto.length];
			Image[] changedImg = new Image[vegePhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\vege\\vege\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,170, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			vegePhoto[i] = Icon[i];   
		}

		//흑백
		for ( int i = 0; i < vegePhoto1.length; i++)
		{
			String[] imgPath = new String[vegePhoto1.length];
			ImageIcon[] originIcon = new ImageIcon[vegePhoto1.length];
			ImageIcon[] Icon = new ImageIcon[vegePhoto1.length];
			Image[] originImg = new Image[vegePhoto1.length];
			Image[] changedImg = new Image[vegePhoto1.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\vege\\vege1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,170, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			vegePhoto1[i] = Icon[i];   
		}

		vegetableMenus = new JButton[3][3];
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				vegetableMenus[i][j] = new JButton(vegePhoto[3*i+j]);
				vegetableMenu.add(vegetableMenus[i][j]);
				vegetableMenus[i][j].addActionListener(this);
				vegetableMenus[i][j].setBackground(Color.white);
				vegetableMenus[i][j].setPreferredSize(new Dimension(200,185));
			}
		}
		vegetable.add(vegetableMenu, BorderLayout.CENTER);
		vegetable.add(vegetableOption , BorderLayout.SOUTH);
		f.add(vegetable , BorderLayout.CENTER);
		f.setVisible(true);
	}

	void selectSauce()
	{
		sauce = new JPanel();
		sauceMenu = new JPanel();   
		f.remove(vegetable);
		f.setVisible(false);
		sauce.setLayout(new BorderLayout());
		sauceMenu.setBackground(Color.WHITE);

		//화면하단
		sauceOption = new JPanel();
		sauceOption.setLayout(new BorderLayout());
		sauceOption.setBackground(Color.white);
		OrderToEnd = new JButton(buttonPhoto[0]);
		OrderToEnd.setBackground(Color.white);
		OrderToEnd.setBorder(BorderFactory.createEmptyBorder());
		OrderToEnd.addActionListener(this);
		sauceTovege = new JButton(buttonPhoto[1]);
		sauceTovege.setBackground(Color.white);
		sauceTovege.setBorder(BorderFactory.createEmptyBorder());
		sauceOption.add(sauceTovege, BorderLayout.WEST);
		sauceOption.add(OrderToEnd,BorderLayout.EAST);      
		sauceTovege.addActionListener(this);

		//컬러
		for ( int i = 0; i < saucePhoto.length; i++)
		{
			String[] imgPath = new String[saucePhoto.length];
			ImageIcon[] originIcon = new ImageIcon[saucePhoto.length];
			ImageIcon[] Icon = new ImageIcon[saucePhoto.length];
			Image[] originImg = new Image[saucePhoto.length];
			Image[] changedImg = new Image[saucePhoto.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\sauce\\sauce\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,170, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			saucePhoto[i] = Icon[i];   
		}

		//흑백
		for ( int i = 0; i < saucePhoto1.length; i++)
		{
			String[] imgPath = new String[saucePhoto1.length];
			ImageIcon[] originIcon = new ImageIcon[saucePhoto1.length];
			ImageIcon[] Icon = new ImageIcon[saucePhoto1.length];
			Image[] originImg = new Image[saucePhoto1.length];
			Image[] changedImg = new Image[saucePhoto1.length];

			imgPath[i] = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\sauce\\sauce1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(200,170, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			saucePhoto1[i] = Icon[i];   
		}
		sauceMenus = new JButton[3][3];
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3 ; j++) 
			{
				sauceMenus[i][j] = new JButton(saucePhoto[3*i+j]);
				sauceMenu.add(sauceMenus[i][j]);
				sauceMenus[i][j].addActionListener(this);
				sauceMenus[i][j].setBackground(Color.white);
				sauceMenus[i][j].setPreferredSize(new Dimension(200,185));
			}
		}
		sauce.add(sauceMenu , BorderLayout.CENTER);
		sauce.add(sauceOption , BorderLayout.SOUTH);
		f.add(sauce , BorderLayout.CENTER);
		f.setVisible(true);
	}

	int selectSet() 
	{
		//신규 set 여부창

		String[] yesNo = {setYes.getActionCommand(), setNo.getActionCommand()};
		int howSet = JOptionPane.showOptionDialog(null, "세트로 구매하시겠습니까?", "세트 여부", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, yesNo, "예");
		return howSet;  //예 - 0 반환 , 아니오 - 1 반환

	}

	void selectSide() {//신규 음료, 쿠키 선택 화면

		side = new JPanel();
		sideMenu = new JPanel();
		sideMenu.setBackground(Color.WHITE);
		f.remove(sauce);
		f.setVisible(false);
		side.setLayout(new BorderLayout());

		//하단
		sideOption = new JPanel();
		sideOption.setBackground(Color.white);
		sideOption.setLayout(new BorderLayout());
		sideTosauce = new JButton(buttonPhoto[1]);
		sideTosauce.setBackground(Color.white);
		sideTopay = new JButton(buttonPhoto[0]);
		sideTopay.setBackground(Color.white);
		sideOption.setBorder(BorderFactory.createEmptyBorder());
		sideTosauce.addActionListener(this);
		sideTopay.addActionListener(this);
		sideOption.add(sideTosauce, BorderLayout.WEST);
		sideOption.add(sideTopay,BorderLayout.EAST);

		JPanel sub = new JPanel();
		sub.setBackground(Color.WHITE);
		JButton subway = new JButton(new ImageIcon("C:\\Java\\Workspace\\Advanced\\src\\project\\arrow\\subway.jpg"));
		subway.setBackground(Color.white);
		subway.setBorder(BorderFactory.createEmptyBorder ());
		sub.add(subway);
		sideOption.add(sub, BorderLayout.CENTER);

		//컬러
		for ( int i = 0; i < setPhoto.length; i++)
		{
			String[] imgPath = new String[setPhoto.length];
			ImageIcon[] originIcon = new ImageIcon[setPhoto.length];
			ImageIcon[] Icon = new ImageIcon[setPhoto.length];
			Image[] originImg = new Image[setPhoto.length];
			Image[] changedImg = new Image[setPhoto.length];

			imgPath[i] = "C:\\Java\\Workspace\\Advanced\\src\\project\\set\\set\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(110,180, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			setPhoto[i] = Icon[i];   
		}

		//흑백
		for ( int i = 0; i < setPhoto.length; i++)
		{
			String[] imgPath = new String[setPhoto.length];
			ImageIcon[] originIcon = new ImageIcon[setPhoto.length];
			ImageIcon[] Icon = new ImageIcon[setPhoto.length];
			Image[] originImg = new Image[setPhoto.length];
			Image[] changedImg = new Image[setPhoto.length];

			imgPath[i] = "C:\\Java\\Workspace\\Advanced\\src\\project\\set\\set1\\"+i+".jpg";   
			originIcon[i] = new ImageIcon(imgPath[i]);
			originImg[i] = originIcon[i].getImage(); 
			changedImg[i]= originImg[i].getScaledInstance(110,180, Image.SCALE_SMOOTH);
			Icon[i] = new ImageIcon(changedImg[i]);
			setPhoto1[i] = Icon[i];   
		}

		//콜라
		cokeCookie=new JPanel();
		//cokeCookie.setLayout(new GridLayout(2,5));
		coke=new JButton(setPhoto[5]);
		coke.setPreferredSize(new Dimension(130,185));
		coke.setBackground(Color.white);
		coke.setBounds(20,300,120,180);
		coke.addActionListener(this);
		//,BorderLayout.NORTH

		//sideMenu.setLayout(null);
		//쿠키
		cookie=new JButton[5];
		for (int i = 0; i < 5; i++) 
		{
			cookie[i] = new JButton(setPhoto[i]);
			cookie[i].setPreferredSize(new Dimension(130,185));
			cookie[i].addActionListener(this);
			cookie[i].setBackground(Color.white);
			sideMenu.add(cookie[i]);
		}
		sideMenu.add(coke);

		//cokeCookie.add(sideMenu);
		//cokeCookie.add(coke);
		side.setBackground(Color.white);
		side.add(sideMenu, BorderLayout.CENTER);
		side.add(sideOption, BorderLayout.SOUTH);
		f.add(side , BorderLayout.CENTER);
		f.setVisible(true);
	}


	void orderlist() 
	{
		//신규 주문확인창

		JLabel listname=new JLabel("<주문 확인>");
		JLabel orderSandwich= new JLabel("                                    <샌드위치>");
		JLabel orderSide= new JLabel("                                           <사이드>");
		//listname.setFont(new Font("NanumGothic", Font.BOLD, 30));
		JTextArea ta=new JTextArea(5,20);
		JTextField tf=new JTextField(30);
		order = new JPanel();
		orderDetail = new JPanel();
		orderTosauce = new JButton("이전");
		orderTopay = new JButton("카드결제");
		orderOption = new JPanel();

		String[] menuImg= 
			{
					"classic" , "fresh" , "premium"
			};

		String imgPath2 = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\menu\\"+
				menuImg[MenuData[0]] +"\\"+MenuData[1]+".jpg";   
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2= originImg2.getScaledInstance(200,150, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(changedImg2);

		if (MenuData[4] != -1)
		{
			String imgPath3 = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\set\\"+
					(MenuData[4]+1) +".jpg";   
			ImageIcon originIcon3 = new ImageIcon(imgPath3);
			Image originImg3 = originIcon3.getImage();
			Image changedImg3= originImg3.getScaledInstance(140,100, Image.SCALE_SMOOTH);
			ImageIcon Icon3 = new ImageIcon(changedImg3);

			String imgPath4 = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\set\\set\\5.jpg";   
			ImageIcon originIcon4 = new ImageIcon(imgPath4);
			Image originImg4 = originIcon4.getImage();
			Image changedImg4= originImg4.getScaledInstance(140,100, Image.SCALE_SMOOTH);
			ImageIcon Icon4 = new ImageIcon(changedImg4);

			JLabel selectedCook = new JLabel(Icon3);
			JLabel selectedCoke = new JLabel(Icon4);

			pCook = new JPanel();
			pCook.setLayout(new BorderLayout());
			pCook.add(orderSide , BorderLayout.NORTH);
			pCook.add(selectedCook , BorderLayout.WEST);
			pCook.add(selectedCoke , BorderLayout.EAST);

			order.add(pCook);

			pCook.setSize(300,200);
			pCook.setLocation(50, 350);
		}


		f.remove(set);
		f.setVisible(false);
		orderOption.setLayout(new GridLayout(1,2));
		orderOption.add(orderTosauce);
		orderOption.add(orderTopay);
		orderTosauce.addActionListener(this);
		orderTopay.addActionListener(this);

		JLabel selectedSand = new JLabel(Icon2);

		orderDetail = new JPanel();
		String imgPathBack = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\arrow\\3.jpg";   
		ImageIcon originIconBack = new ImageIcon(imgPathBack);
		Image originImgBack = originIconBack.getImage();
		Image changedImgBack= originImgBack.getScaledInstance(80,40, Image.SCALE_SMOOTH);
		ImageIcon IconBack = new ImageIcon(changedImgBack);
		orderTosauce = new JButton( IconBack );
		orderTosauce.setBackground(Color.white);

		String imgPathNext = "C:\\Java\\WorkSpace\\Advanced\\src\\project\\arrow\\2.jpg";   
		ImageIcon originIconNext = new ImageIcon(imgPathNext);
		Image originImgNext = originIconNext.getImage();
		Image changedImgNext= originImgNext.getScaledInstance(80,40, Image.SCALE_SMOOTH);
		ImageIcon IconNext = new ImageIcon(changedImgNext);
		orderTopay = new JButton( IconNext);
		orderTopay.setBackground(Color.white);
		orderTosauce.addActionListener(this);
		orderTopay.addActionListener(this);





		pSand = new JPanel();
		pSand.setLayout(new BorderLayout());
		pSand.add(selectedSand , BorderLayout.SOUTH);
		pSand.add(orderSandwich , BorderLayout.NORTH);

		order.setLayout(null);
		order.add(orderTosauce);
		order.add(orderTopay);
		order.add(listname);
		order.add(orderOption);
		order.add(pSand);

		order.add(ta);

		pSand.setSize(300,200);
		pSand.setLocation(50, 100);
		listname.setSize(400,100);
		listname.setLocation(500, 10);
		ta.setSize(250, 400);
		ta.setLocation(400, 150);
		orderTosauce.setSize(80,40);
		orderTosauce.setLocation(30 , 620);
		orderTopay.setSize(80,40);
		orderTopay.setLocation(580 , 620);

		String msg1 = "";
		String msg2 = "빵종류           : " + breadMenu2[MenuData[2]] + "\n\n";
		String msg3 = "제외할 채소     : ";
		String msg4 = "치즈 종류       : ";
		String msg5 = "추가할 토핑    : ";
		String msg6 = "소스 종류       : ";
		if (MenuData[0] == 0)
		{
			msg1 = "샌드위치 종류 : " + ClassicMenu2[MenuData[1]] + "\n\n";
		}
		else if (MenuData[0] == 1)
		{
			msg1 = "샌드위치 종류 : " + FandLMenu2[MenuData[1]] + "\n\n";
		}
		else if (MenuData[0] == 2)
		{
			msg1 = "샌드위치 종류 : " + PremiumMenu2[MenuData[1]] + "\n\n";
		}
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				if (vegetableSelecting[i][j])
				{
					msg3 = msg3 + VeseMenu2[3*i+j] +"  ";
				}
			}
		}
		msg3 = msg3 +"\n\n";
		if (MenuData[6] == 0)
		{
			msg4 = msg4 + "아메리칸 치즈 \n\n";
		}
		else
		{
			msg4 = msg4 + "슈레드 치즈 \n\n";
		}

		for (int i = 1; i < 3; i++) 
		{
			for (int j = 0; j < 2; j++)
			{
				if (toppingSelecting[i][j])
				{
					msg5 = msg5 + toppingMenu2[2*i+j-2] + "  ";
				}
			}
		}
		msg5 = msg5 + "\n\n";

		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				if (sauceSelecting[i][j])
				{
					msg6 = msg6 + sauceMenu2[3*i+j] + "  ";
				}
			}
		}
		msg6 = msg6 + "\n\n";

		String msg = "샌드위치 타입 : "+allMenu2[MenuData[0]] + "\n\n" + msg1 + msg2 + msg3 +msg4 + msg5 + msg6;
		ta.setText(msg);
















		f.add(order);
		f.setVisible(true);
	}

	void cardPay() 
	{
		//신규 카드결제창

		card=new JPanel();
		card.setLayout(new BorderLayout());
		cardImage= new JButton(new ImageIcon("C:\\Users\\student\\Desktop\\eclipse\\work_0829\\사진\\KakaoTalk_20180828_172616153.jpg"));

		f.remove(order);
		f.setVisible(false);

		card.add(cardImage, BorderLayout.CENTER);
		f.add(card, BorderLayout.CENTER);
		f.setVisible(true);

	}

	void OrderEnd() 
	{
		//신규 마지막창

		card=new JPanel();
		card.setLayout(new BorderLayout());
		cardImage= new JButton(new ImageIcon("C:\\Users\\student\\Desktop\\eclipse\\work_0829\\사진\\KakaoTalk_20180828_172616458.jpg"));

		f.remove(card);
		f.setVisible(false);

		card.add(cardImage, BorderLayout.CENTER);
		f.add(card, BorderLayout.CENTER);
		f.setVisible(true);
	}











	public void sqlTest()
	{
		String[] ClassicMenu =
			{
					"비엘티" , "미트볼" , "이탈리안 비엠티" , "에그마요" , "참치" , "햄"
			};

		String[] FandLMenu = 
			{
					"로스트 치킨" , "써브웨이 클럽" , "터키" , " 로스트 비프" , "베지" , "로티세리 치킨"
			};

		String[] PremiumMenu =
			{
					"치킨 데리야끼" , "스파이시 이탈리안" , "터키 베이컨" , "써브웨이 멜트" , "치킨 베이컨 랜치" , "폴드포크"
			};

		String[] breadMenu =
			{
					"허니 오트" , "하티" , "위트" , "파마산 오레가노" , "플랫브래드" , "화이트"
			};

		String[] cookieMenu = 
			{
					"더블 초코칩 쿠키" , "초코칩 쿠키" , "오트밀레이즌" , "라즈베리 치즈케잌" , "화이트 초코 마카다미아"
			};
		String[] toppingMenu =
			{
					"에그마요" , "오믈렛" , "아보카도" , "베이컨"      
			};

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Data1;
		String Data2;
		if (MenuData[0] == 0)
		{
			Data1 = "Classic";
			Data2 = ClassicMenu[MenuData[1]];
		}
		else if (MenuData[0] == 1)
		{
			Data1 = "FandL";
			Data2 = FandLMenu[MenuData[1]];
		}
		else
		{
			Data1 = "Premium";
			Data2 = PremiumMenu[MenuData[1]];
		}
		String sql = "update " + Data1 + " set numberSold = (select numberSold from " +Data1 +
				" where name = '" + Data2 +"') + 1 where name = '" + Data2 +"'"; 
		try
		{
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps. executeQuery();
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			JdbcUtil.close(rs, ps, con);
		}

		//====================
		Data2 = breadMenu[MenuData[2]];
		String sql2 = "update bread set numberSold = (select numberSold from bread where name = '" + Data2 +
				"') + 1 where name = '" + Data2 +"'"; 

		try
		{
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql2);
			rs = ps. executeQuery();
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			JdbcUtil.close(rs, ps, con);
		}

		//====================
		if (MenuData[5] == 1)
		{
			String sql3 = "update setmenu set numberSold = (select numberSold from setMenu where title = '세트 주문')"
					+ "+ 1 where title ='세트 주문'"; 

			try
			{
				con = JdbcUtil.getConnection();
				ps = con.prepareStatement(sql3);
				rs = ps. executeQuery();
			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}
			finally 
			{
				JdbcUtil.close(rs, ps, con);
			}
		}
		//====================
		if (MenuData[4] != -1)
		{
			Data2 = cookieMenu[MenuData[4]];
			String sql4 = "update cookie set numberSold = (select numberSold from cookie where name = '" + Data2 +
					"') + 1 where name = '" + Data2 +"'"; 

			try
			{
				con = JdbcUtil.getConnection();
				ps = con.prepareStatement(sql4);
				rs = ps. executeQuery();
			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}
			finally 
			{
				JdbcUtil.close(rs, ps, con);
			}
		}

		//
		//         //====================
		for (int i = 1; i < 3; i++) 
		{
			for (int j = 0; j < 2; j++)
			{
				if (toppingSelecting[i][j])
				{

					Data2 = toppingMenu[2*i+j-2];
					String sql5 = "update topping set numberSold = (select numberSold from topping where title = '" 
							+ Data2 +"') + 1 where title = '" + Data2 +"'"; 


					try
					{
						con = JdbcUtil.getConnection();
						ps = con.prepareStatement(sql5);
						rs = ps. executeQuery();
					}
					catch (SQLException e) 
					{
						System.out.println(e.getMessage());
					}
					finally 
					{
						JdbcUtil.close(rs, ps, con);
					}
				}
			}
		}



	}

	public static int Total()
	{
		String[] allMenu =
			{
					"Classic" , "FandL" , "Premium" , "setMenu" , "topping"
			};

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int total = 0;


		for (int i = 0; i < 5; i++) 
		{
			try
			{
				String sql = "select * from "+allMenu[i] ;
				con = JdbcUtil.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps. executeQuery();
				while(rs.next())
				{
					total = total + rs.getInt("NUMBERSOLD") * rs.getInt("PRICE");
				}

			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}

			finally 
			{
				JdbcUtil.close(rs, ps, con);
			}

		}

		System.out.println(total);
		return total;
	}




	@SuppressWarnings("resource")
	public static void Reset()
	{
		String[] allMenus =
			{
					"Classic" , "FandL" , "Premium" , "setMenu" , "topping"  , "cookie" , "bread"
			};

		String sql ="";
		for (int i = 0; i < 7; i++) 
		{
			sql = "update "+allMenus[i]+"  set numberSold = 0 where numberSold != 0  ";

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try
			{
				con = JdbcUtil.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps. executeQuery();
			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage()); 
			}
			finally 
			{
				JdbcUtil.close(rs, ps, con);
			}
		}
		System.out.println("초기화 완료");
	}

	public static void main(String[] args) 
	{
//		Menu g = new Menu();
//		Reset();
   	Total();

	}
}









