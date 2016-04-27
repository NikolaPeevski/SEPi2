package com.Clerver.domain.model;

public interface ItemBuilder {
	void buildItemName(String name);

	void buildItemStats(int S, int P, int E, int C, int I, int A, int L);

	void buildItemPrice(int price);

	Item getItem();
}
