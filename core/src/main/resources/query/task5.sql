SET search_path TO medical;

SELECT * FROM address ORDER BY id LIMIT (SELECT COUNT(id) / 2 FROM address);