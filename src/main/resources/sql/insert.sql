DELETE FROM `address`;
INSERT INTO `address` (`id`, `country`, `city`, `street`, `home`, `apartment`) VALUES
	(1, 'england', 'london', 'power', '177', '666');
	
DELETE FROM `category`;
INSERT INTO `category` (`id`, `name`) VALUES
	(1, 'soft'),
	(2, 'phones');
	
DELETE FROM `company`;
INSERT INTO `company` (`id`, `name`) VALUES
	(1, 'Microsoft'),
	(2, 'Oracle');
	
DELETE FROM `user`;
INSERT INTO `user` (`id`, `login`, `password`, `firstname`, `lastname`, `photo`, `cash`, `rating`, `role`, `status`) VALUES
	(1, 'rel', '123', 'rel', 'mayer', NULL, 0, 0, 'admin', 'active'),
	(2, 'lil', '123', 'lil', 'torn', NULL, 0, 0, 'user', 'active'),
	(3, 'mel', '123', 'melissa', 'tox', NULL, 0, 0, 'user', 'inactive');
		
DELETE FROM `product`;
INSERT INTO `product` (`id`, `user_id`, `category_id`, `company_id`, `name`, `description`, `cost`, `discount`, `count`, `rating`, `status`) VALUES
	(1, 2, 1, 1, 'os', 'win', 100, 0, 1, 0, 'active');
	
DELETE FROM `order`;
INSERT INTO `order` (`id`, `user_id`, `product_id`, `address_id`, `buying_date`, `delivery_date`, `status`) VALUES
	(1, 3, 1, 1, '2018-05-27', '2018-05-27', 'inactive'),
	(3, 3, 1, 1, '2018-05-27', NULL, 'active'),
	(4, 3, 1, 1, '2018-05-27', NULL, 'active');