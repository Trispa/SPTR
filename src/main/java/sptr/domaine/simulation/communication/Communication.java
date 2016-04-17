/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sptr.domaine.simulation.communication;

import sptr.domaine.simulation.processus.Processus;


/**
 *
 * @author Erco
 */
public class Communication
{

	private int number;
	private String name;
	private Process S;
	private Process D;
	private int dimension;
	private boolean blockingSend;
	private boolean blockingRecv;
	private boolean isUsed;
	


	public Communication(int number,String name, Process S, Process D)
	{
		this.number = number;
		this.S = S;
		this.D = D;
		this.isUsed = false;
		
		if(number == 3)
		{
			//this.dimension =1 u.d. +   inf(longueur_du_chemin_calculé / (param:echelle*8)) u.d.
		}
		
		else if (number == 11)
		{
			//this.dimension = 1 u.d. +   inf(longueur_du_chemin_calculé / (param:echelle*8)) u.d.
		}
		else
		{
			this.dimension = 1;
		}
		
		if(number ==2 )
		{
			this.blockingSend = false;
			this.blockingRecv = true;
		}
		else
		{
			this.blockingSend =false;
			this.blockingRecv = false;
		}
	}

	public int getNumber()
	{
		return this.number;
	}

	public String getName()
	{
		return this.name;
	}

	public Process getS()
	{
		return this.S;
	}

	public Process getD()
	{
		return this.D;
	}

	public boolean isBlockingSend()
	{
		return this.blockingSend;
	}

	public boolean isBlockingRecv()
	{
		return this.blockingRecv;
	}
	
	
	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

}