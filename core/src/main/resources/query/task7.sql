SET search_path TO medical;

CREATE OR REPLACE VIEW person_with_his_phone_and_email_older_30 AS
SELECT last_name, first_name, phone_number, email
FROM person_data
    INNER JOIN contact ON contact.id = person_data.contact_id WHERE person_data.age > 30;