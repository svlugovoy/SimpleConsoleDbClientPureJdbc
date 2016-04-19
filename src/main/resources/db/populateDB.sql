DELETE FROM clients;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO clients (name, age) VALUES
  ('Vasya Pupkin', 25),
  ('Petrik Pyatochkin', 30),
  ('Anna Petrova', 20),
  ('Lee Prist', 40),
  ('Helen Smith', 55);