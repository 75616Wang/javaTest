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
			System.out.println("1查看当前货架所有商品\n2向货架增加商品\n3查询某一商品\n4删除某一商品\n5出售商品\n0退出当前管理系统");
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
					System.out.println("请输入要查询的商品名：");
					suppermacket.query(new Scanner(System.in).nextLine().toString());
					break;
				case 4:
					System.out.println("请输入要删除的商品名称：");
					suppermacket.del(new Scanner(System.in).nextLine().toString());
					break;
				case 5:
					System.out.println("输入出售的商品：");
					try{
						String goodsName=new Scanner(System.in).nextLine().toString();
						for(int i=0;i<rack.size();i++)
						{
							if (rack.get(i).name.equals(goodsName)) {
								System.out.println("输入购买数量：");
								rack.get(i).sale(new Scanner(System.in).nextInt());
							}
						}
					}catch(Exception e)
					{
						System.err.println("非法输入！！！");
					}
				default:
					break;
				}
			} catch(Exception e)
			{
				System.err.println("非法输入！！！");
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
			System.err.println("货架为空！");
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
		System.err.println("不存在该商品！");
	}
	public void addGoods()
	{
		while(true)
		{
			System.out.println("请输入要插入的商品名：");
			String goodsName=new Scanner(System.in).nextLine().toString();
			if(goodsName!=null)
			{
				System.out.println("请输入商品单价：");
				try{
				double goodsPrice=new Scanner(System.in).nextInt();
				System.out.println("请输入商品生产地：");
				String goodsPro=new Scanner(System.in).nextLine().toString();
				System.out.println("请输入商品数量：");
				try{
				int n=new Scanner(System.in).nextInt();
				rack.add(new Goods(goodsName,goodsPrice,goodsPro,n));
				System.out.println("添加成功！");
				}catch(Exception e)
				{
					System.err.println("非法输入！！！\n添加失败！");
				}
				}catch(Exception e)
				{
					System.err.println("非法 输入！！！\n添加失败！");
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
			System.out.println("删除成功！");
			break;
			}
		}
		System.err.println("不存在该商品！");
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
			System.err.println("货源不足！");
			return false;
		}else
		{
			new user().pay(this, n);
			count-=n;
			System.out.println("出售成功！");
			return true;
		}
	}
	public void add(int n)
	{
		count+=n;
	}
	public void showMe()
	{
		System.out.print("商品名："+name);
		System.out.print("\t价  格："+price);
		System.out.print("\t产  地："+producer);
		System.out.println("\t剩余数量："+count);
	}
}
class user{
	private String username;
	private double banlance=99;
	public void pay(Goods g,int n)
	{
		if(g.price*n>banlance)
		{
			System.err.println("余额不足！！！");
		}
		else 
		{
			banlance-=n*g.price;
			System.out.println("余额"+banlance);
		}
	}
}