SET search_path TO medical;

SELECT kid.last_name AS kid_last_name,
       kid.first_name AS kid_first_name,
       parent.last_name AS parent_last_name,
       parent.first_name AS parent_first_name
FROM person_data AS kid
    LEFT JOIN  person_data AS parent ON kid.parent_id=parent.id
WHERE kid.medical_card_id IN (
    SELECT id
    FROM medical_card
    WHERE med_status is null
);