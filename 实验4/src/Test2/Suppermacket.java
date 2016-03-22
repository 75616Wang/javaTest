package Test2;

import java.util.ArrayList;
import java.util.Scanner;

public class Suppermacket
{
	java.util.List<Goods>rack=new ArrayList<>();
	public static void main(String[] args) {
		java.util.List<Goods>rack=new ArrayList<>();
		Suppermacket suppermacket=new Suppermacket(rack);
		while(true)
		{
			System.out.println("1�鿴��ǰ����������Ʒ\n2�����������Ʒ\n3��ѯĳһ��Ʒ\n4ɾ��ĳһ��Ʒ\n5������Ʒ\n0�˳���ǰ����ϵͳ");
			try {
				int key=new Scanner(System.in).nextInt();
				if(key==0)break;
				switch (key) {
				case 1:
					suppermacket.check();
					break;
				case 2:
					suppermacket.addGoods();
					break;
				case 3:
					System.out.println("������Ҫ��ѯ����Ʒ����");
					suppermacket.query(new Scanner(System.in).nextLine().toString());
					break;
				case 4:
					System.out.println("������Ҫɾ������Ʒ���ƣ�");
					suppermacket.del(new Scanner(System.in).nextLine().toString());
					break;
				case 5:
					System.out.println("������۵���Ʒ��");
					try{
						String goodsName=new Scanner(System.in).nextLine().toString();
						for(int i=0;i<rack.size();i++)
						{
							if (rack.get(i).name.equals(goodsName)) {
								System.out.println("���빺��������");
								rack.get(i).sale(new Scanner(System.in).nextInt());
							}
						}
					}catch(Exception e)
					{
						System.err.println("�Ƿ����룡����");
					}
				default:
					break;
				}
			} catch(Exception e)
			{
				System.err.println("�Ƿ����룡����");
			}
		}
	}
	public Suppermacket(java.util.List<Goods>rack) {
		
		// TODO Auto-generated constructor stub
		this.rack=rack;
	}
	public void check()
	{
		if(rack.size()==0){
			System.err.println("����Ϊ�գ�");
		}
		Goods[]goods=new Goods[rack.size()];
		for(int i=0;i<rack.size();i++)
		{
			goods[i]=rack.get(i);
			goods[i].showMe();
		}
	}
	public void query(String goodsName)
	{
		for (Goods goods : rack) {
			if(goods.name.equals(goodsName))
			{
				goods.showMe();
				break;
			}
		}
		System.err.println("�����ڸ���Ʒ��");
	}
	public void addGoods()
	{
		while(true)
		{
			System.out.println("������Ҫ�������Ʒ����");
			String goodsName=new Scanner(System.in).nextLine().toString();
			if(goodsName!=null)
			{
				System.out.println("��������Ʒ���ۣ�");
				try{
				double goodsPrice=new Scanner(System.in).nextInt();
				System.out.println("��������Ʒ�����أ�");
				String goodsPro=new Scanner(System.in).nextLine().toString();
				System.out.println("��������Ʒ������");
				try{
				int n=new Scanner(System.in).nextInt();
				rack.add(new Goods(goodsName,goodsPrice,goodsPro,n));
				System.out.println("��ӳɹ���");
				}catch(Exception e)
				{
					System.err.println("�Ƿ����룡����\n���ʧ�ܣ�");
				}
				}catch(Exception e)
				{
					System.err.println("�Ƿ� ���룡����\n���ʧ�ܣ�");
				}
				break;
			}
		}
	}
	public void del(String goodsName)
	{
		for(int i=0;i<rack.size();i++)
		{
			if(rack.get(i).name.equals(goodsName))
			{
			rack.remove(i);
			System.out.println("ɾ���ɹ���");
			break;
			}
		}
		System.err.println("�����ڸ���Ʒ��");
	}
}
class Goods
{
	protected String name;
	protected double price;
	protected String producer;
	protected int count;
	public Goods(String name,double price,String producer,
		int n)
	{
		this.name=name;
		this.price=price;
		this.producer=producer;
		this.count=n;
	}
	public boolean sale(int n)
	{
		if(n>this.count)
		{
			System.err.println("��Դ���㣡");
			return false;
		}else
		{
			new user().pay(this, n);
			count-=n;
			System.out.println("���۳ɹ���");
			return true;
		}
	}
	public void add(int n)
	{
		count+=n;
	}
	public void showMe()
	{
		System.out.print("��Ʒ����"+name);
		System.out.print("\t��  ��"+price);
		System.out.print("\t��  �أ�"+producer);
		System.out.println("\tʣ��������"+count);
	}
}
class user{
	private String username;
	private double banlance=99;
	public void pay(Goods g,int n)
	{
		if(g.price*n>banlance)
		{
			System.err.println("���㣡����");
		}
		else 
		{
			banlance-=n*g.price;
			System.out.println("���"+banlance);
		}
	}
}