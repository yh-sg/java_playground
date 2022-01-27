CREATE TABLE tbl_character (id SERIAL PRIMARY KEY, name VARCHAR(255));

INSERT INTO tbl_character (name) VALUES 
('Teio'),
('Scarlet'),
('Spe-Chan'),
('Vodka'),
('Kyaru'),
('Kasumi');

-- This Statement must pass
DO 
$$DECLARE 
	allNames VARCHAR[];
	allNameArray VARCHAR[]:= ARRAY(SELECT name FROM tbl_character);
	result boolean;
	BEGIN
	   	SELECT ARRAY_AGG(name) INTO allNames FROM tbl_character;
	   	SELECT 'Kyaru' = ANY (allNameArray) INTO result;
	   	
	   	RAISE INFO 'All name: %', allNames;
	   	RAISE INFO 'All array names: %', allNameArray;
	   	RAISE INFO 'RESULT ---------> %', result;
	   	ASSERT result='t';
	   	ASSERT (SELECT 'Teio' = ANY(allNameArray))='t';
	   	ASSERT (SELECT 'Yui' = ANY(allNameArray))='f';
END$$;

-- This Statement will 100% fail and stop the migration
DO 
$$DECLARE 
	expectedNameCounts INTEGER := 10;
	actualNameCounts INTEGER;
	BEGIN
	   	SELECT COUNT(*) INTO actualNameCounts FROM tbl_character;
	   	
	   	ASSERT expectedNameCounts = actualNameCounts, CONCAT('Expected ',expectedNameCounts, ' names but actual count is ', actualNameCounts ,' check the script');
END$$;