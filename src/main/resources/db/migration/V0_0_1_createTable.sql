CREATE TABLE todo (id INT UNSIGNED NOT NULL AUTO_INCREMENT, 
name varchar(50) NOT NULL, is_finished tinyint(1) NOT NULL DEFAULT 0, 
is_active tinyint(1) NOT NULL DEFAULT 1, created_at timestamp NOT NULL DEFAULT now(), updated_at timestamp NOT NULL,
PRIMARY KEY(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

CREATE TABLE tags (id INT UNSIGNED NOT NULL AUTO_INCREMENT, 
name varchar(50) NOT NULL, 
is_active tinyint(1) NOT NULL DEFAULT 1, created_at timestamp NOT NULL DEFAULT now(), updated_at timestamp NOT NULL,
PRIMARY KEY(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

CREATE TABLE todos_tags (id INT UNSIGNED AUTO_INCREMENT, 
todo_id INT UNSIGNED NOT NULL, tags_id INT UNSIGNED,
PRIMARY KEY(id),
FOREIGN KEY (`todo_id`) REFERENCES `todo` (`id`),
FOREIGN KEY (`tags_id`) REFERENCES `tags` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 