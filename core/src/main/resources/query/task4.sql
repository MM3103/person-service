SET search_path TO medical;

DELETE FROM address AS ad1 USING address AS ad2 WHERE ad1.id > ad2.id
  AND ad1.contact_id = ad2.contact_id
  AND ad1.country_id = ad2.country_id
  AND ad1.city = ad2.city
  AND ad1.index = ad2.index
  AND ad1.street = ad2.street
  AND ad1.building = ad2.building
  AND ad1.flat = ad2.flat;