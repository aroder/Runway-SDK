INSERT INTO class_cache (set_id, item_id)  VALUES  ('sx0uvtwiomsvkbqh98imn0udlla1qzth', '0000000000000000000000000000023100000000000000000000000000000222');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('0bvnki290jpsftq8ukhpsnw6jg4iaslqNM200904120000000000000000000030', '0bvnki290jpsftq8ukhpsnw6jg4iaslqNM200904120000000000000000000030', 'www.runwaysdk.com', 'Operations');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('1xlcaod6rx989x2093ad5yd80f2u3mirNM200904120000000000000000000030', '1xlcaod6rx989x2093ad5yd80f2u3mirNM200904120000000000000000000030', 'www.runwaysdk.com', 'Math Operations Enumeration Master List');
INSERT INTO md_business ( super_md_business, cache_algorithm, cache_algorithm_c, id) VALUES ('0000000000000000000000000000020600000000000000000000000000000001', 'sx0uvtwiomsvkbqh98imn0udlla1qzth', '0000000000000000000000000000023100000000000000000000000000000222', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO md_element ( is_abstract, extendable, id) VALUES (0, 0, 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO md_entity ( cache_size, query_dto_source, has_deterministic_ids, enforce_site_master, query_source, table_name, id) VALUES (0, NULL, 1, 1, NULL, 'operators', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO md_class ( stub_source, publish, stub_dto_source, id) VALUES (NULL, 1, NULL, 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO md_type ( type_name, js_stub, display_label, exported, generate_source, js_base, base_source, package_name, root_id, dto_source, id) VALUES ('Operators', NULL, '0bvnki290jpsftq8ukhpsnw6jg4iaslqNM200904120000000000000000000030', 1, 1, NULL, NULL, 'com.runwaysdk.system', 'id54wqqzc9di1afrjzzihwcrrw58i3sz', NULL, 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO metadata ( create_date, seq, type, created_by, last_update_date, last_updated_by, description, locked_by, remove, owner, entity_domain, id, key_name, site_master) VALUES ('2017-06-07 20:45:40', 4852, 'com.runwaysdk.system.metadata.MdBusiness', '0000000000000000000000000000001000000000000000000000000000000003', '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', '1xlcaod6rx989x2093ad5yd80f2u3mirNM200904120000000000000000000030', NULL, 0, '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'com.runwaysdk.system.Operators', 'www.runwaysdk.com');
CREATE TABLE operators ( id CHAR(64) NOT NULL PRIMARY KEY );
INSERT INTO business_inheritance ( id, parent_id, child_id) VALUES ('id54wqqzc9di1afrjzzihwcrrw58i3sz20070926NM0000000000000000000004', '0000000000000000000000000000020600000000000000000000000000000001', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO class_inheritance ( id, parent_id, child_id) VALUES ('id54wqqzc9di1afrjzzihwcrrw58i3sz20070926NM0000000000000000000004', '0000000000000000000000000000020600000000000000000000000000000001', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('id54wqqzc9di1afrjzzihwcrrw58i3sz20070926NM0000000000000000000004', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.BusinessInheritance', '2017-06-07 20:45:40', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4853, 'com.runwaysdk.system.Operators', NULL, NULL, '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', '0000000000000000000000000000020600000000000000000000000000000001', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('z1u1k7oy3pl2xsf5e4u439zn4scvi2erNM200904120000000000000000000030', 'z1u1k7oy3pl2xsf5e4u439zn4scvi2erNM200904120000000000000000000030', 'www.runwaysdk.com', 'RatioMathOperations');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('swq9afev7zz01dpgugywnfdv0miv08rnNM200904120000000000000000000030', 'swq9afev7zz01dpgugywnfdv0miv08rnNM200904120000000000000000000030', 'www.runwaysdk.com', 'Ratio Math Operation Enumeration');
INSERT INTO md_enumeration ( master_md_business, table_name, include_all, id) VALUES ('id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'ratio_math_operations', 1, 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196');
INSERT INTO md_type ( type_name, js_stub, display_label, exported, generate_source, js_base, base_source, package_name, root_id, dto_source, id) VALUES ('RatioOperators', NULL, 'z1u1k7oy3pl2xsf5e4u439zn4scvi2erNM200904120000000000000000000030', 1, 1, NULL, NULL, 'com.runwaysdk.system', 'id3xpta1dykcruimoapb4dji07r1lkfc', NULL, 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196');
INSERT INTO metadata ( create_date, seq, type, created_by, last_update_date, last_updated_by, description, locked_by, remove, owner, entity_domain, id, key_name, site_master) VALUES ('2017-06-07 20:45:40', 4854, 'com.runwaysdk.system.metadata.MdEnumeration', '0000000000000000000000000000001000000000000000000000000000000003', '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', 'swq9afev7zz01dpgugywnfdv0miv08rnNM200904120000000000000000000030', NULL, 0, '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196', 'com.runwaysdk.system.RatioOperators', 'www.runwaysdk.com');
INSERT INTO enumeration_attribute ( id, parent_id, child_id) VALUES ('id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000212', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000212', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.EnumerationAttribute', '2017-06-07 20:45:40', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4855, 'com.runwaysdk.system.RatioOperators', NULL, NULL, '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196');

CREATE TABLE ratio_math_operations 
(set_id                CHAR(32) NOT NULL, 
item_id CHAR(64) NOT NULL);
CREATE UNIQUE INDEX aid3xpta1dykcruimoapb4dji07r1l ON ratio_math_operations (set_id, item_id);
INSERT INTO md_attribute_indicies (set_id, item_id)  VALUES  ('2exwhmvhmmg3fancmf097mhrj2t7htg8', '0000000000000000000000000000040900000000000000000000000000000403');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('xjz72ww58estv94jlws57mscxuveslcm', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('zj0o4uneaq5r4qvmt3b6h10cnoy7wpm5', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('z7hd0l72q9km419t63kmlasbj1ee99g3NM200904120000000000000000000030', 'z7hd0l72q9km419t63kmlasbj1ee99g3NM200904120000000000000000000030', 'www.runwaysdk.com', 'Operation');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('039dq4kawv0akdvn3eagu622rje5dr3aNM200904120000000000000000000030', '039dq4kawv0akdvn3eagu622rje5dr3aNM200904120000000000000000000030', 'www.runwaysdk.com', NULL);
INSERT INTO md_attribute_character ( default_value, database_size, id) VALUES (NULL, 1, 'i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
INSERT INTO md_attribute_char ( id) VALUES ('i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
INSERT INTO md_attribute_primitive ( is_expression, expression, id) VALUES (0, NULL, 'i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
INSERT INTO md_attribute_concrete ( defining_md_class, column_name, index_type, index_type_c, attribute_name, getter_visibility, getter_visibility_c, system, index_name, setter_visibility, setter_visibility_c, required, generate_accessor, display_label, immutable, id) VALUES ('id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'operator_symbol', '2exwhmvhmmg3fancmf097mhrj2t7htg8', '0000000000000000000000000000040900000000000000000000000000000403', 'operatorSymbol', 'xjz72ww58estv94jlws57mscxuveslcm', '20071109NM000000000000000000000520071109NM0000000000000000000001', 0, 'a7z134tpfa54tyt4z8xbrsf6e0yvrs', 'zj0o4uneaq5r4qvmt3b6h10cnoy7wpm5', '20071109NM000000000000000000000520071109NM0000000000000000000001', 1, 1, 'z7hd0l72q9km419t63kmlasbj1ee99g3NM200904120000000000000000000030', 0, 'i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
INSERT INTO md_attribute ( id) VALUES ('i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
INSERT INTO metadata ( create_date, seq, type, created_by, last_update_date, last_updated_by, description, locked_by, remove, owner, entity_domain, id, key_name, site_master) VALUES ('2017-06-07 20:45:40', 4856, 'com.runwaysdk.system.metadata.MdAttributeCharacter', '0000000000000000000000000000001000000000000000000000000000000003', '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', '039dq4kawv0akdvn3eagu622rje5dr3aNM200904120000000000000000000030', NULL, 0, '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138', 'com.runwaysdk.system.Operators.operatorSymbol', 'www.runwaysdk.com');
ALTER TABLE operators ADD COLUMN operator_symbol  varchar(1);
INSERT INTO class_attribute_concrete ( id, parent_id, child_id) VALUES ('i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000073', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
INSERT INTO class_attribute ( id, parent_id, child_id) VALUES ('i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000073', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000073', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.ClassAttributeConcrete', '2017-06-07 20:45:40', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4857, 'com.runwaysdk.system.Operators.operatorSymbol', NULL, NULL, '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001', 'i92rzbupmlvuzxfhggbcl81e2uf64dpy00000000000000000000000000000138');
CREATE UNIQUE INDEX a7z134tpfa54tyt4z8xbrsf6e0yvrs ON operators (operator_symbol);
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('xxm5cv3i6h237trsk98swxi4f3vmr6oxNM200904120000000000000000000030', 'xxm5cv3i6h237trsk98swxi4f3vmr6oxNM200904120000000000000000000030', 'www.runwaysdk.com', 'California');
INSERT INTO operators ( operator_symbol, id) VALUES ('/', 'ii1e2bpqmvw2w1pt7nki9v10a0j4os5mid54wqqzc9di1afrjzzihwcrrw58i3sz');
INSERT INTO enumeration_master ( site_master, last_updated_by, owner, locked_by, key_name, type, enum_name, display_label, id, last_update_date, create_date, created_by, entity_domain, seq) VALUES ('www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'com.runwaysdk.system.Operators.DIV', 'com.runwaysdk.system.Operators', 'DIV', 'xxm5cv3i6h237trsk98swxi4f3vmr6oxNM200904120000000000000000000030', 'ii1e2bpqmvw2w1pt7nki9v10a0j4os5mid54wqqzc9di1afrjzzihwcrrw58i3sz', '2017-06-07 20:45:40', '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', NULL, 4858);
INSERT INTO enumeration_attribute_item ( id, parent_id, child_id) VALUES ('ijdnwrxqyhv2mibsfssa29r3u7nnuawz00000000000000000000000000000294', 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196', 'ii1e2bpqmvw2w1pt7nki9v10a0j4os5mid54wqqzc9di1afrjzzihwcrrw58i3sz');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('ijdnwrxqyhv2mibsfssa29r3u7nnuawz00000000000000000000000000000294', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.EnumerationAttributeItem', '2017-06-07 20:45:40', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4859, 'com.runwaysdk.system.RatioOperators.DIV', NULL, NULL, '2017-06-07 20:45:40', '0000000000000000000000000000001000000000000000000000000000000003', 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196', 'ii1e2bpqmvw2w1pt7nki9v10a0j4os5mid54wqqzc9di1afrjzzihwcrrw58i3sz');

UPDATE md_enumeration SET master_md_business= 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001' , table_name= 'ratio_math_operations' , include_all= 1 , id= 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196'  WHERE id='id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196';
UPDATE md_type SET type_name= 'RatioOperators' , display_label= 'z1u1k7oy3pl2xsf5e4u439zn4scvi2erNM200904120000000000000000000030' , package_name= 'com.runwaysdk.system' , root_id= 'id3xpta1dykcruimoapb4dji07r1lkfc' , id= 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196'  WHERE id='id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196';
UPDATE metadata SET create_date= '2017-06-07 20:45:40' , seq= 4860 , type= 'com.runwaysdk.system.metadata.MdEnumeration' , created_by= '0000000000000000000000000000001000000000000000000000000000000003' , last_update_date= '2017-06-07 20:45:40' , last_updated_by= '0000000000000000000000000000001000000000000000000000000000000003' , description= 'swq9afev7zz01dpgugywnfdv0miv08rnNM200904120000000000000000000030' , remove= 0 , owner= '0000000000000000000000000000001000000000000000000000000000000003' , id= 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196' , key_name= 'com.runwaysdk.system.RatioOperators' , site_master= 'www.runwaysdk.com'  WHERE id='id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196';
UPDATE md_business SET super_md_business= '0000000000000000000000000000020600000000000000000000000000000001' , cache_algorithm= 'sx0uvtwiomsvkbqh98imn0udlla1qzth' , cache_algorithm_c= '0000000000000000000000000000023100000000000000000000000000000222' , id= 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001'  WHERE id='id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001';
UPDATE md_element SET extendable= 0 , id= 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001'  WHERE id='id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001';
UPDATE md_entity SET has_deterministic_ids= 1 , table_name= 'operators' , id= 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001'  WHERE id='id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001';
UPDATE md_type SET type_name= 'Operators' , display_label= '0bvnki290jpsftq8ukhpsnw6jg4iaslqNM200904120000000000000000000030' , package_name= 'com.runwaysdk.system' , root_id= 'id54wqqzc9di1afrjzzihwcrrw58i3sz' , id= 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001'  WHERE id='id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001';
UPDATE metadata SET create_date= '2017-06-07 20:45:40' , seq= 4861 , type= 'com.runwaysdk.system.metadata.MdBusiness' , created_by= '0000000000000000000000000000001000000000000000000000000000000003' , last_update_date= '2017-06-07 20:45:40' , last_updated_by= '0000000000000000000000000000001000000000000000000000000000000003' , description= '1xlcaod6rx989x2093ad5yd80f2u3mirNM200904120000000000000000000030' , remove= 0 , owner= '0000000000000000000000000000001000000000000000000000000000000003' , id= 'id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001' , key_name= 'com.runwaysdk.system.Operators' , site_master= 'www.runwaysdk.com'  WHERE id='id54wqqzc9di1afrjzzihwcrrw58i3sz00000000000000000000000000000001';

INSERT INTO class_cache (set_id, item_id)  VALUES  ('2gjedf3ks0hxwmhyffto7yaraa5tq9hl', '0000000000000000000000000000023100000000000000000000000000000222');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('8iyx3ux2urq8yemr1n3s8i8qz4ouhhiwNM200904120000000000000000000030', '8iyx3ux2urq8yemr1n3s8i8qz4ouhhiwNM200904120000000000000000000030', 'www.runwaysdk.com', 'MdAttributeRatio');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('xse0etomcksjrtahane2opz84q161qigNM200904120000000000000000000030', 'xse0etomcksjrtahane2opz84q161qigNM200904120000000000000000000030', 'www.runwaysdk.com', 'Ratio attribute metadata');
INSERT INTO md_business ( super_md_business, cache_algorithm, cache_algorithm_c, id) VALUES ('0000000000000000000000000000000200000000000000000000000000000001', '2gjedf3ks0hxwmhyffto7yaraa5tq9hl', '0000000000000000000000000000023100000000000000000000000000000222', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO md_element ( is_abstract, extendable, id) VALUES (0, 1, 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO md_entity ( cache_size, query_dto_source, has_deterministic_ids, enforce_site_master, query_source, table_name, id) VALUES (0, NULL, 1, 1, NULL, 'md_attribute_ratio', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO md_class ( stub_source, publish, stub_dto_source, id) VALUES (NULL, 1, NULL, 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO md_type ( type_name, js_stub, display_label, exported, generate_source, js_base, base_source, package_name, root_id, dto_source, id) VALUES ('MdAttributeRatio', NULL, '8iyx3ux2urq8yemr1n3s8i8qz4ouhhiwNM200904120000000000000000000030', 1, 1, NULL, NULL, 'com.runwaysdk.system.metadata', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r36', NULL, 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO metadata ( create_date, seq, type, created_by, last_update_date, last_updated_by, description, locked_by, remove, owner, entity_domain, id, key_name, site_master) VALUES ('2017-06-07 21:59:01', 4860, 'com.runwaysdk.system.metadata.MdBusiness', '0000000000000000000000000000001000000000000000000000000000000003', '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', 'xse0etomcksjrtahane2opz84q161qigNM200904120000000000000000000030', NULL, 0, '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'com.runwaysdk.system.metadata.MdAttributeRatio', 'www.runwaysdk.com');
CREATE TABLE md_attribute_ratio ( id CHAR(64) NOT NULL PRIMARY KEY );
INSERT INTO business_inheritance ( id, parent_id, child_id) VALUES ('i60dbot7mh1xwisrr1a6r0pfk9ew9r3620070926NM0000000000000000000004', '0000000000000000000000000000000200000000000000000000000000000001', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO class_inheritance ( id, parent_id, child_id) VALUES ('i60dbot7mh1xwisrr1a6r0pfk9ew9r3620070926NM0000000000000000000004', '0000000000000000000000000000000200000000000000000000000000000001', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('i60dbot7mh1xwisrr1a6r0pfk9ew9r3620070926NM0000000000000000000004', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.BusinessInheritance', '2017-06-07 21:59:01', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4861, 'com.runwaysdk.system.metadata.MdAttributeRatio', NULL, NULL, '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', '0000000000000000000000000000000200000000000000000000000000000001', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001');
INSERT INTO md_attribute_indicies (set_id, item_id)  VALUES  ('senw6c2u7o7bcwie239kwzpg4ilznn6i', '0000000000000000000000000000040000000000000000000000000000000403');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('6qsh1zobykzi3akq59kt1ojwkammezy6', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('xaw2ig8z3m91rj7jlwe0an9xhbpdmt69', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('1sjuto1ql6fm79i1fn5ikjtmgh9fet9mNM200904120000000000000000000030', '1sjuto1ql6fm79i1fn5ikjtmgh9fet9mNM200904120000000000000000000030', 'www.runwaysdk.com', 'Left Operand');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('ze3yl7vgn3ylkq5kta4aqzw3z3pzl2f2NM200904120000000000000000000030', 'ze3yl7vgn3ylkq5kta4aqzw3z3pzl2f2NM200904120000000000000000000030', 'www.runwaysdk.com', 'The left operand in the ratio equation');
INSERT INTO md_attribute_reference ( default_value, md_business, id) VALUES (NULL, 'NM20081019000000000000000000000300000000000000000000000000000001', 'ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186');
INSERT INTO md_attribute_ref ( id) VALUES ('ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186');
INSERT INTO md_attribute_concrete ( defining_md_class, column_name, index_type, index_type_c, attribute_name, getter_visibility, getter_visibility_c, system, index_name, setter_visibility, setter_visibility_c, required, generate_accessor, display_label, immutable, id) VALUES ('i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'left_operand', 'senw6c2u7o7bcwie239kwzpg4ilznn6i', '0000000000000000000000000000040000000000000000000000000000000403', 'leftOperand', '6qsh1zobykzi3akq59kt1ojwkammezy6', '20071109NM000000000000000000000520071109NM0000000000000000000001', 0, 'ajidsevyn0m4ouh6tn6nn1vt3xml3w', 'xaw2ig8z3m91rj7jlwe0an9xhbpdmt69', '20071109NM000000000000000000000520071109NM0000000000000000000001', 1, 1, '1sjuto1ql6fm79i1fn5ikjtmgh9fet9mNM200904120000000000000000000030', 0, 'ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186');
INSERT INTO md_attribute ( id) VALUES ('ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186');
INSERT INTO metadata ( create_date, seq, type, created_by, last_update_date, last_updated_by, description, locked_by, remove, owner, entity_domain, id, key_name, site_master) VALUES ('2017-06-07 21:59:01', 4862, 'com.runwaysdk.system.metadata.MdAttributeReference', '0000000000000000000000000000001000000000000000000000000000000003', '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', 'ze3yl7vgn3ylkq5kta4aqzw3z3pzl2f2NM200904120000000000000000000030', NULL, 0, '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186', 'com.runwaysdk.system.metadata.MdAttributeRatio.leftOperand', 'www.runwaysdk.com');
ALTER TABLE md_attribute_ratio ADD COLUMN left_operand  char(64);
INSERT INTO class_attribute_concrete ( id, parent_id, child_id) VALUES ('ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000073', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186');
INSERT INTO class_attribute ( id, parent_id, child_id) VALUES ('ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000073', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000073', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.ClassAttributeConcrete', '2017-06-07 21:59:01', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4863, 'com.runwaysdk.system.metadata.MdAttributeRatio.leftOperand', NULL, NULL, '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'ijguf6cgtolw599b9lg8z6wm5x7p3whf00000000000000000000000000000186');
CREATE INDEX ajidsevyn0m4ouh6tn6nn1vt3xml3w ON md_attribute_ratio (left_operand);
INSERT INTO md_attribute_indicies (set_id, item_id)  VALUES  ('1pi97zo63i3etgop0pnp9t0bnmlk4eck', '0000000000000000000000000000040100000000000000000000000000000403');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('25nfiibiyzdg5dq21hlxo36yh7qgvcxf', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('r8cnyf9d1tml5ql7sbybqy9dy3h9191q', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('qwxau21if09eamynkbvfewuhh8bhnrs5NM200904120000000000000000000030', 'qwxau21if09eamynkbvfewuhh8bhnrs5NM200904120000000000000000000030', 'www.runwaysdk.com', 'Operator');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('8tm9rd23merxdckcw30qgizdq4k18io3NM200904120000000000000000000030', '8tm9rd23merxdckcw30qgizdq4k18io3NM200904120000000000000000000030', 'www.runwaysdk.com', 'The operator in the ratio equation');
INSERT INTO md_attribute_enumeration ( default_value, md_enumeration, select_multiple, cache_column_name, id) VALUES ('ii1e2bpqmvw2w1pt7nki9v10a0j4os5mid54wqqzc9di1afrjzzihwcrrw58i3sz', 'id3xpta1dykcruimoapb4dji07r1lkfc00000000000000000000000000000196', 0, 'math_operator_c', 'i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216');
INSERT INTO md_attribute_ref ( id) VALUES ('i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216');
INSERT INTO md_attribute_concrete ( defining_md_class, column_name, index_type, index_type_c, attribute_name, getter_visibility, getter_visibility_c, system, index_name, setter_visibility, setter_visibility_c, required, generate_accessor, display_label, immutable, id) VALUES ('i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'math_operator', '1pi97zo63i3etgop0pnp9t0bnmlk4eck', '0000000000000000000000000000040100000000000000000000000000000403', 'operator', '25nfiibiyzdg5dq21hlxo36yh7qgvcxf', '20071109NM000000000000000000000520071109NM0000000000000000000001', 0, 'aed6fpx850dleor54obikg8pavwqez', 'r8cnyf9d1tml5ql7sbybqy9dy3h9191q', '20071109NM000000000000000000000520071109NM0000000000000000000001', 1, 1, 'qwxau21if09eamynkbvfewuhh8bhnrs5NM200904120000000000000000000030', 0, 'i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216');
INSERT INTO md_attribute ( id) VALUES ('i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216');
INSERT INTO metadata ( create_date, seq, type, created_by, last_update_date, last_updated_by, description, locked_by, remove, owner, entity_domain, id, key_name, site_master) VALUES ('2017-06-07 21:59:01', 4864, 'com.runwaysdk.system.metadata.MdAttributeEnumeration', '0000000000000000000000000000001000000000000000000000000000000003', '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', '8tm9rd23merxdckcw30qgizdq4k18io3NM200904120000000000000000000030', NULL, 0, '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216', 'com.runwaysdk.system.metadata.MdAttributeRatio.operator', 'www.runwaysdk.com');
ALTER TABLE md_attribute_ratio ADD COLUMN math_operator  char(32);
ALTER TABLE md_attribute_ratio ADD COLUMN math_operator_c  text;
INSERT INTO class_attribute_concrete ( id, parent_id, child_id) VALUES ('i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000073', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216');
INSERT INTO class_attribute ( id, parent_id, child_id) VALUES ('i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000073', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000073', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.ClassAttributeConcrete', '2017-06-07 21:59:01', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4865, 'com.runwaysdk.system.metadata.MdAttributeRatio.operator', NULL, NULL, '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'i7aahu6hikl3w8fejtuzhztoehkn1kwu00000000000000000000000000000216');
INSERT INTO md_attribute_indicies (set_id, item_id)  VALUES  ('1y60jjr9l5f7f4it6xkev0svm6p9dvwg', '0000000000000000000000000000040000000000000000000000000000000403');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('29gngbobor5r4fq0lg98umix67exem32', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO visibilitymodifier (set_id, item_id)  VALUES  ('qzzam5mkrvyhusupcw1am90us71jc14q', '20071109NM000000000000000000000520071109NM0000000000000000000001');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('y1x1wfdurfytlkww0vh90j480u14ax7zNM200904120000000000000000000030', 'y1x1wfdurfytlkww0vh90j480u14ax7zNM200904120000000000000000000030', 'www.runwaysdk.com', 'Right Operand');
INSERT INTO metadata_display_label ( key_name, id, site_master, default_locale) VALUES ('z2vlacuvgm1rjxy57l8gj7t6hv57zqeyNM200904120000000000000000000030', 'z2vlacuvgm1rjxy57l8gj7t6hv57zqeyNM200904120000000000000000000030', 'www.runwaysdk.com', 'The right operand in the ratio equation');
INSERT INTO md_attribute_reference ( default_value, md_business, id) VALUES (NULL, 'NM20081019000000000000000000000300000000000000000000000000000001', 'idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186');
INSERT INTO md_attribute_ref ( id) VALUES ('idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186');
INSERT INTO md_attribute_concrete ( defining_md_class, column_name, index_type, index_type_c, attribute_name, getter_visibility, getter_visibility_c, system, index_name, setter_visibility, setter_visibility_c, required, generate_accessor, display_label, immutable, id) VALUES ('i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'right_operand', '1y60jjr9l5f7f4it6xkev0svm6p9dvwg', '0000000000000000000000000000040000000000000000000000000000000403', 'rightOperand', '29gngbobor5r4fq0lg98umix67exem32', '20071109NM000000000000000000000520071109NM0000000000000000000001', 0, 'agxcwh97139ywn0r2lou8yy2b5h601', 'qzzam5mkrvyhusupcw1am90us71jc14q', '20071109NM000000000000000000000520071109NM0000000000000000000001', 1, 1, 'y1x1wfdurfytlkww0vh90j480u14ax7zNM200904120000000000000000000030', 0, 'idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186');
INSERT INTO md_attribute ( id) VALUES ('idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186');
INSERT INTO metadata ( create_date, seq, type, created_by, last_update_date, last_updated_by, description, locked_by, remove, owner, entity_domain, id, key_name, site_master) VALUES ('2017-06-07 21:59:01', 4866, 'com.runwaysdk.system.metadata.MdAttributeReference', '0000000000000000000000000000001000000000000000000000000000000003', '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', 'z2vlacuvgm1rjxy57l8gj7t6hv57zqeyNM200904120000000000000000000030', NULL, 0, '0000000000000000000000000000001000000000000000000000000000000003', NULL, 'idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186', 'com.runwaysdk.system.metadata.MdAttributeRatio.rightOperand', 'www.runwaysdk.com');
ALTER TABLE md_attribute_ratio ADD COLUMN right_operand  char(64);
INSERT INTO class_attribute_concrete ( id, parent_id, child_id) VALUES ('idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000073', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186');
INSERT INTO class_attribute ( id, parent_id, child_id) VALUES ('idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000073', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186');
INSERT INTO metadata_relationship ( id, created_by, type, last_update_date, site_master, owner, seq, key_name, entity_domain, locked_by, create_date, last_updated_by, parent_id, child_id) VALUES ('idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000073', '0000000000000000000000000000001000000000000000000000000000000003', 'com.runwaysdk.system.metadata.ClassAttributeConcrete', '2017-06-07 21:59:01', 'www.runwaysdk.com', '0000000000000000000000000000001000000000000000000000000000000003', 4867, 'com.runwaysdk.system.metadata.MdAttributeRatio.rightOperand', NULL, NULL, '2017-06-07 21:59:01', '0000000000000000000000000000001000000000000000000000000000000003', 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001', 'idb3ibkivgcu317e3xpw2ikndawfpofl00000000000000000000000000000186');
CREATE INDEX agxcwh97139ywn0r2lou8yy2b5h601 ON md_attribute_ratio (right_operand);
UPDATE md_business SET super_md_business= '0000000000000000000000000000000200000000000000000000000000000001' , cache_algorithm= '2gjedf3ks0hxwmhyffto7yaraa5tq9hl' , cache_algorithm_c= '0000000000000000000000000000023100000000000000000000000000000222' , id= 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001'  WHERE id='i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001';
UPDATE md_entity SET has_deterministic_ids= 1 , table_name= 'md_attribute_ratio' , id= 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001'  WHERE id='i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001';
UPDATE md_type SET type_name= 'MdAttributeRatio' , display_label= '8iyx3ux2urq8yemr1n3s8i8qz4ouhhiwNM200904120000000000000000000030' , package_name= 'com.runwaysdk.system.metadata' , root_id= 'i60dbot7mh1xwisrr1a6r0pfk9ew9r36' , id= 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001'  WHERE id='i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001';
UPDATE metadata SET create_date= '2017-06-07 21:59:01' , seq= 4868 , type= 'com.runwaysdk.system.metadata.MdBusiness' , created_by= '0000000000000000000000000000001000000000000000000000000000000003' , last_update_date= '2017-06-07 21:59:01' , last_updated_by= '0000000000000000000000000000001000000000000000000000000000000003' , description= 'xse0etomcksjrtahane2opz84q161qigNM200904120000000000000000000030' , remove= 0 , owner= '0000000000000000000000000000001000000000000000000000000000000003' , id= 'i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001' , key_name= 'com.runwaysdk.system.metadata.MdAttributeRatio' , site_master= 'www.runwaysdk.com'  WHERE id='i60dbot7mh1xwisrr1a6r0pfk9ew9r3600000000000000000000000000000001';
