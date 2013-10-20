1) Просмотр спискаблюд и названия рецептов для каждого блюда.
1) select product.name, recipe.name from product, recipe where product.idProduct = recipe.Product_id;

2) select provider_id, ingredient_id, max(receiptDate) from bill where receiptDate < ? group by provider_id, ingredient_id;

2) select bill.provider_id, bill.price, max(bill.receiptDate) from bill where bill.receiptDate < ? group by bill.ingredient_id, bill.provider_id having bill.provider_id = 1;

2) Просмотр прайс-листа заданного поставщика на заданную дату – дата, реквизиты поставщика, название ингредиента, его стоимость за единицу.

try 1
select
max(bill.receiptDate) as billDate,
provider.name as providerName,
provider.code as providerCode,
provider.address as providerAddress,
provider.phone as providerPhone,
ingredient.name as ingredientName,
bill.price
from bill
join provider
  on bill.provider_id = provider.idProvider
join ingredient
  on bill.ingredient_id = ingredient.idIngredient
where bill.receiptDate < "2013-12-12"
group by bill.ingredient_id, bill.provider_id
having bill.provider_id = 1;

try 2  norm
select
max(bill.receiptDate) as billDate,
provider.name as providerName,
provider.code as providerCode,
provider.address as providerAddress,
provider.phone as providerPhone,
ingredient.name as ingredientName,
bill.price
from bill
join provider
  on bill.provider_id = provider.idProvider
join ingredient
  on bill.ingredient_id = ingredient.idIngredient
where bill.receiptDate < "2013-12-12"
group by bill.ingredient_id, bill.provider_id
having bill.provider_id = 1;

try 3

select
bill.idBill,
bill.price,
max(bill.receiptDate) as billDate,
provider.idProvider as providerId,
provider.name as providerName,
provider.code as providerCode,
provider.address as providerAddress,
provider.phone as providerPhone,
ingredient.idIngredient as ingredientId,
ingredient.name as ingredientName
from bill
join provider
  on bill.provider_id = provider.idProvider
join ingredient
  on bill.ingredient_id = ingredient.idIngredient
where bill.receiptDate < "2013-10-21"
group by bill.ingredient_id, bill.provider_id
having bill.provider_id = 1;

try last

select
bill.price,
bill.idBill,
max(bill.receiptDate) as billDate,
provider.idProvider as providerId,
provider.name as providerName,
provider.code as providerCode,
provider.address as providerAddress,
provider.phone as providerPhone,
ingredient.name as ingredientName,
ingredient.idIngredient as ingredientId
from bill
join provider
  on bill.provider_id = provider.idProvider
join ingredient
  on bill.ingredient_id = ingredient.idIngredient
where bill.receiptDate < "2013-12-12"
group by bill.ingredient_id, bill.provider_id
having bill.provider_id = 1;



3) список блюд с минимальной калорийностью

select
sum(gramNum * caloriesNumPerGram) as calories,
product.name
from recipe_ingredient
join ingredient
 on recipe_ingredient.ingredient_id = ingredient.idIngredient
join recipe
 on recipe_ingredient.recipe_id = recipe.idRecipe
join product
 on recipe.product_Id = product.IdProduct
group by recipe_id
order by calories
 limit 5;

