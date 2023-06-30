package vn.oitstar.dao;

import java.util.List;
import java.util.Locale.Category;

import vn.oitstar.model.CategoryModel;

public interface CategoryDaoo {
	void insert(Category category);
	void edit(CategoryModel oldCategory);
	void delete(int id);
	Category get(int id);
	Category get(String name);
	List<Category> getAll();
	List<Category> search(String keyword);
}
