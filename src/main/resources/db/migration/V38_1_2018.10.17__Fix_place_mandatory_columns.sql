ALTER TABLE place ALTER COLUMN location SET NOT NULL;
ALTER TABLE place ALTER COLUMN altitude DROP NOT NULL;
ALTER TABLE place ALTER COLUMN name DROP NOT NULL;

