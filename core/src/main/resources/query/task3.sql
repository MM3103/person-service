SET search_path TO medical;

SELECT * FROM medical_card AS medc
                  INNER JOIN person_data AS persd ON medc.id = persd.medical_card_id;

