/*
Navicat PGSQL Data Transfer

Source Server         : localPosgre
Source Server Version : 90304
Source Host           : localhost:5432
Source Database       : UnyuSchedue
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90304
File Encoding         : 65001

Date: 2014-05-25 14:05:27
*/


-- ----------------------------
-- Sequence structure for "seq_bidang_keahlian"
-- ----------------------------
DROP SEQUENCE "seq_bidang_keahlian";
CREATE SEQUENCE "seq_bidang_keahlian"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_jdwl_smn_sdg"
-- ----------------------------
DROP SEQUENCE "seq_jdwl_smn_sdg";
CREATE SEQUENCE "seq_jdwl_smn_sdg"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_karya_akhir"
-- ----------------------------
DROP SEQUENCE "seq_karya_akhir";
CREATE SEQUENCE "seq_karya_akhir"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_ketersediaan_dosen"
-- ----------------------------
DROP SEQUENCE "seq_ketersediaan_dosen";
CREATE SEQUENCE "seq_ketersediaan_dosen"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 47
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_koordinator"
-- ----------------------------
DROP SEQUENCE "seq_koordinator";
CREATE SEQUENCE "seq_koordinator"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_pembimbing"
-- ----------------------------
DROP SEQUENCE "seq_pembimbing";
CREATE SEQUENCE "seq_pembimbing"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_penguji"
-- ----------------------------
DROP SEQUENCE "seq_penguji";
CREATE SEQUENCE "seq_penguji"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_periode"
-- ----------------------------
DROP SEQUENCE "seq_periode";
CREATE SEQUENCE "seq_periode"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 20
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_seminar"
-- ----------------------------
DROP SEQUENCE "seq_seminar";
CREATE SEQUENCE "seq_seminar"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_seminar_sidang"
-- ----------------------------
DROP SEQUENCE "seq_seminar_sidang";
CREATE SEQUENCE "seq_seminar_sidang"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_sidang"
-- ----------------------------
DROP SEQUENCE "seq_sidang";
CREATE SEQUENCE "seq_sidang"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for "seq_topik"
-- ----------------------------
DROP SEQUENCE "seq_topik";
CREATE SEQUENCE "seq_topik"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for "bidang_dosen"
-- ----------------------------
DROP TABLE "bidang_dosen";
CREATE TABLE "bidang_dosen" (
"nik_dosen" varchar(30) NOT NULL,
"id_bidang" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of bidang_dosen
-- ----------------------------
BEGIN;
INSERT INTO "bidang_dosen" VALUES ('23513029', '1');
INSERT INTO "bidang_dosen" VALUES ('23513029', '2');
INSERT INTO "bidang_dosen" VALUES ('23513056', '1');
INSERT INTO "bidang_dosen" VALUES ('23513056', '2');
INSERT INTO "bidang_dosen" VALUES ('23513068', '1');
INSERT INTO "bidang_dosen" VALUES ('23513068', '2');
COMMIT;

-- ----------------------------
-- Table structure for "dosen"
-- ----------------------------
DROP TABLE "dosen";
CREATE TABLE "dosen" (
"nik_dosen" varchar(30) NOT NULL,
"nm_dosen" varchar(100),
"alamat_dsn" varchar(200),
"jns_klmn_dsn" int4,
"username" varchar(255),
"password" varchar(255)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of dosen
-- ----------------------------
BEGIN;
INSERT INTO "dosen" VALUES ('23513029', 'Juno', 'Cimahi', '1', 'juno', 'juno');
INSERT INTO "dosen" VALUES ('23513056', 'Esa', 'Margahayu', '1', 'esa', 'esa');
INSERT INTO "dosen" VALUES ('23513068', 'Dika', 'Cimuncang', '1', 'dika', 'dika');
INSERT INTO "dosen" VALUES ('23513132', 'Nofa', 'Gresik', '1', 'nofa', 'nofa');
COMMIT;

-- ----------------------------
-- Table structure for "jadwal_detail"
-- ----------------------------
DROP TABLE "jadwal_detail";
CREATE TABLE "jadwal_detail" (
"id_slot" int8 NOT NULL,
"tanggal" date,
"id_ruangan" varchar(20),
"id_jam" int8,
"id_jdwl_ss" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of jadwal_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "jam_kuliah_hari"
-- ----------------------------
DROP TABLE "jam_kuliah_hari";
CREATE TABLE "jam_kuliah_hari" (
"id_jam" int8 NOT NULL,
"waktu_jam" varchar(30)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of jam_kuliah_hari
-- ----------------------------
BEGIN;
INSERT INTO "jam_kuliah_hari" VALUES ('1', '07.00 - 08.00');
INSERT INTO "jam_kuliah_hari" VALUES ('2', '08.00 - 09.00');
INSERT INTO "jam_kuliah_hari" VALUES ('3', '09.00 - 10.00');
INSERT INTO "jam_kuliah_hari" VALUES ('4', '10.00 - 11.00');
INSERT INTO "jam_kuliah_hari" VALUES ('5', '13.00 - 14.00');
INSERT INTO "jam_kuliah_hari" VALUES ('6', '14.00 - 15.00');
INSERT INTO "jam_kuliah_hari" VALUES ('7', '16.00 - 17.00');
COMMIT;

-- ----------------------------
-- Table structure for "jdwl_smn_sdg"
-- ----------------------------
DROP TABLE "jdwl_smn_sdg";
CREATE TABLE "jdwl_smn_sdg" (
"id_jdw_ss" int8 NOT NULL,
"id_smnsdg" int8,
"id_periode" int8,
"slot_waktu_id" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of jdwl_smn_sdg
-- ----------------------------
BEGIN;
INSERT INTO "jdwl_smn_sdg" VALUES ('0', '1', null, null);
COMMIT;

-- ----------------------------
-- Table structure for "jenis_ka"
-- ----------------------------
DROP TABLE "jenis_ka";
CREATE TABLE "jenis_ka" (
"id_jenis_ka" int8 NOT NULL,
"nama_jenis" varchar(150)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of jenis_ka
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "ka_topik"
-- ----------------------------
DROP TABLE "ka_topik";
CREATE TABLE "ka_topik" (
"id_ka" int8 NOT NULL,
"id_topik" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ka_topik
-- ----------------------------
BEGIN;
INSERT INTO "ka_topik" VALUES ('1', '1');
INSERT INTO "ka_topik" VALUES ('2', '2');
COMMIT;

-- ----------------------------
-- Table structure for "karya_akhir"
-- ----------------------------
DROP TABLE "karya_akhir";
CREATE TABLE "karya_akhir" (
"id_ka" int8 NOT NULL,
"nim" varchar(30),
"id_jenis_ka" int8,
"judul_ka" varchar(300),
"status_ka" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of karya_akhir
-- ----------------------------
BEGIN;
INSERT INTO "karya_akhir" VALUES ('1', '23513029', null, 'Sistem Berbasis A', '0');
INSERT INTO "karya_akhir" VALUES ('2', '23513056', null, 'Framework X', '0');
COMMIT;

-- ----------------------------
-- Table structure for "ketersediaan_dosen"
-- ----------------------------
DROP TABLE "ketersediaan_dosen";
CREATE TABLE "ketersediaan_dosen" (
"id_ketersediaan" int8 NOT NULL,
"nik_dosen" varchar(100),
"tanggal_sedia" date,
"id_jam" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ketersediaan_dosen
-- ----------------------------
BEGIN;
INSERT INTO "ketersediaan_dosen" VALUES ('2', '23513029', '2014-05-28', '3');
INSERT INTO "ketersediaan_dosen" VALUES ('3', '23513029', '2014-05-28', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('7', '23513029', '2014-05-28', '5');
INSERT INTO "ketersediaan_dosen" VALUES ('8', '23513029', '2014-05-29', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('23', '23513029', '2014-05-29', '5');
INSERT INTO "ketersediaan_dosen" VALUES ('24', '23513029', '2014-05-29', '6');
INSERT INTO "ketersediaan_dosen" VALUES ('26', '23513029', '2014-05-30', '2');
INSERT INTO "ketersediaan_dosen" VALUES ('27', '23513029', '2014-05-30', '3');
INSERT INTO "ketersediaan_dosen" VALUES ('29', '23513029', '2014-05-27', '1');
INSERT INTO "ketersediaan_dosen" VALUES ('30', '23513029', '2014-05-27', '2');
INSERT INTO "ketersediaan_dosen" VALUES ('31', '23513029', '2014-05-27', '3');
INSERT INTO "ketersediaan_dosen" VALUES ('46', '23513029', '2014-05-26', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('47', '23513029', '2014-05-26', '5');
INSERT INTO "ketersediaan_dosen" VALUES ('112', '23513029', '2014-05-30', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('113', '23513056', '2014-05-28', '3');
INSERT INTO "ketersediaan_dosen" VALUES ('114', '23513056', '2014-05-28', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('115', '23513056', '2014-05-28', '5');
INSERT INTO "ketersediaan_dosen" VALUES ('116', '23513068', '2014-05-29', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('117', '23513068', '2014-05-29', '5');
INSERT INTO "ketersediaan_dosen" VALUES ('118', '23513068', '2014-05-29', '6');
INSERT INTO "ketersediaan_dosen" VALUES ('119', '23513132', '2014-05-28', '3');
INSERT INTO "ketersediaan_dosen" VALUES ('120', '23513132', '2014-05-28', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('121', '23513132', '2014-05-28', '5');
INSERT INTO "ketersediaan_dosen" VALUES ('122', '23513132', '2014-06-29', '4');
INSERT INTO "ketersediaan_dosen" VALUES ('123', '23513132', '2014-06-29', '5');
INSERT INTO "ketersediaan_dosen" VALUES ('124', '23513132', '2014-06-29', '6');
INSERT INTO "ketersediaan_dosen" VALUES ('125', '23513068', '2014-06-30', '2');
INSERT INTO "ketersediaan_dosen" VALUES ('126', '23513068', '2014-06-30', '3');
INSERT INTO "ketersediaan_dosen" VALUES ('127', '23513068', '2014-06-30', '4');
COMMIT;

-- ----------------------------
-- Table structure for "ketersediaan_ruangan"
-- ----------------------------
DROP TABLE "ketersediaan_ruangan";
CREATE TABLE "ketersediaan_ruangan" (
"id_ket_ruangan" int8 NOT NULL,
"id_ruangan" varchar(100),
"tanggal" date,
"id_jam" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ketersediaan_ruangan
-- ----------------------------
BEGIN;
INSERT INTO "ketersediaan_ruangan" VALUES ('1', 'IF301', '2014-05-28', '1');
INSERT INTO "ketersediaan_ruangan" VALUES ('2', 'IF301', '2014-05-28', '2');
INSERT INTO "ketersediaan_ruangan" VALUES ('3', 'IF301', '2014-05-28', '3');
INSERT INTO "ketersediaan_ruangan" VALUES ('4', 'IF301', '2014-05-28', '4');
INSERT INTO "ketersediaan_ruangan" VALUES ('5', 'IF301', '2014-05-28', '5');
INSERT INTO "ketersediaan_ruangan" VALUES ('6', 'IF301', '2014-05-28', '6');
INSERT INTO "ketersediaan_ruangan" VALUES ('7', 'IF302', '2014-05-29', '4');
INSERT INTO "ketersediaan_ruangan" VALUES ('8', 'IF302', '2014-05-29', '5');
INSERT INTO "ketersediaan_ruangan" VALUES ('9', 'IF302', '2014-05-29', '6');
INSERT INTO "ketersediaan_ruangan" VALUES ('10', 'IF303', '2014-05-30', '2');
INSERT INTO "ketersediaan_ruangan" VALUES ('11', 'IF303', '2014-05-30', '3');
INSERT INTO "ketersediaan_ruangan" VALUES ('12', 'IF303', '2014-05-30', '4');
INSERT INTO "ketersediaan_ruangan" VALUES ('13', 'IF302', '2014-06-02', '1');
INSERT INTO "ketersediaan_ruangan" VALUES ('14', 'IF302', '2014-06-02', '2');
INSERT INTO "ketersediaan_ruangan" VALUES ('15', 'IF302', '2014-06-02', '3');
COMMIT;

-- ----------------------------
-- Table structure for "koordinator"
-- ----------------------------
DROP TABLE "koordinator";
CREATE TABLE "koordinator" (
"id_koordinator" int4 NOT NULL,
"nik_dosen" varchar(20)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of koordinator
-- ----------------------------
BEGIN;
INSERT INTO "koordinator" VALUES ('2', '23513029');
COMMIT;

-- ----------------------------
-- Table structure for "mahasiswa"
-- ----------------------------
DROP TABLE "mahasiswa";
CREATE TABLE "mahasiswa" (
"nim" varchar(30) NOT NULL,
"id_ka" int8,
"nm_mhs" varchar(100),
"almt_mhs" varchar(200),
"jns_klmn_mhs" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mahasiswa
-- ----------------------------
BEGIN;
INSERT INTO "mahasiswa" VALUES ('23513029', '1', 'Junno', 'Cimahi', '1');
INSERT INTO "mahasiswa" VALUES ('23513056', '2', 'Esa', 'Margahayu', '1');
INSERT INTO "mahasiswa" VALUES ('23513068', null, 'Dika', 'Margahayu', '1');
INSERT INTO "mahasiswa" VALUES ('23513132', null, 'Nofa', 'Margahayu', '1');
INSERT INTO "mahasiswa" VALUES ('23513999', null, 'Akurapopo', 'what', '1');
COMMIT;

-- ----------------------------
-- Table structure for "pembimbing"
-- ----------------------------
DROP TABLE "pembimbing";
CREATE TABLE "pembimbing" (
"nik_dosen" varchar(30) NOT NULL,
"id_ka" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of pembimbing
-- ----------------------------
BEGIN;
INSERT INTO "pembimbing" VALUES ('23513029', '1');
INSERT INTO "pembimbing" VALUES ('23513056', '2');
COMMIT;

-- ----------------------------
-- Table structure for "penguji"
-- ----------------------------
DROP TABLE "penguji";
CREATE TABLE "penguji" (
"nik_dosen" varchar(30) NOT NULL,
"id_smnsdg" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of penguji
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "periode"
-- ----------------------------
DROP TABLE "periode";
CREATE TABLE "periode" (
"id_periode" int8 NOT NULL,
"sem_periode" varchar(30),
"thn_periode" int4,
"rentang_kts_awal" timestamp(6),
"rentang_kts_akhir" timestamp(6),
"rentang_sdg_awal" timestamp(6),
"rentang_sdg_akhir" timestamp(6),
"status_generate" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of periode
-- ----------------------------
BEGIN;
INSERT INTO "periode" VALUES ('11', '1444', '144', '2014-05-09 17:33:29', '2014-05-09 17:33:39', '2014-05-09 17:33:43', '2014-05-09 17:33:46', null);
INSERT INTO "periode" VALUES ('13', '1787', '2014', '2014-05-11 09:00:00', '2014-05-16 16:00:00', '2014-05-18 09:00:00', '2014-05-30 16:00:00', null);
INSERT INTO "periode" VALUES ('16', '2014', '2014', '2014-05-11 00:00:00', '2014-05-13 00:00:00', '2014-05-28 00:00:00', '2014-06-02 14:00:00', null);
INSERT INTO "periode" VALUES ('18', '1444', '2014', '2014-05-07 00:00:00', '2014-05-16 00:00:00', '2014-05-18 00:00:00', '2014-05-10 00:00:00', null);
COMMIT;

-- ----------------------------
-- Table structure for "ruangan"
-- ----------------------------
DROP TABLE "ruangan";
CREATE TABLE "ruangan" (
"id_ruangan" varchar(20) NOT NULL,
"nm_ruangan" varchar(100)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ruangan
-- ----------------------------
BEGIN;
INSERT INTO "ruangan" VALUES ('IF301', '');
INSERT INTO "ruangan" VALUES ('IF302', null);
INSERT INTO "ruangan" VALUES ('IF303', null);
COMMIT;

-- ----------------------------
-- Table structure for "seminar"
-- ----------------------------
DROP TABLE "seminar";
CREATE TABLE "seminar" (
"id_seminar" int8 NOT NULL,
"id_smnsdg" int8,
"ket_seminar" varchar(150)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of seminar
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "seminar_sidang"
-- ----------------------------
DROP TABLE "seminar_sidang";
CREATE TABLE "seminar_sidang" (
"id_smnsdg" int8 NOT NULL,
"id_jdw_ss" int8,
"id_ka" int8,
"status_selesai" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of seminar_sidang
-- ----------------------------
BEGIN;
INSERT INTO "seminar_sidang" VALUES ('1', null, null, '0');
INSERT INTO "seminar_sidang" VALUES ('2', null, null, '0');
COMMIT;

-- ----------------------------
-- Table structure for "sidang"
-- ----------------------------
DROP TABLE "sidang";
CREATE TABLE "sidang" (
"id_sidang" int8 NOT NULL,
"id_smnsdg" int8,
"ket_sidang" varchar(200),
"status_lulus" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sidang
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "topik"
-- ----------------------------
DROP TABLE "topik";
CREATE TABLE "topik" (
"id_topik" int4 NOT NULL,
"nm_topik" varchar(150)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of topik
-- ----------------------------
BEGIN;
INSERT INTO "topik" VALUES ('1', 'Rekayasa Perangkat Lunak');
INSERT INTO "topik" VALUES ('2', 'Ilmu Komputer');
INSERT INTO "topik" VALUES ('3', 'Jaringan');
INSERT INTO "topik" VALUES ('4', 'Sistem Informasi');
COMMIT;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table bidang_dosen
-- ----------------------------
CREATE INDEX "bidang_dosen2_fk" ON "bidang_dosen" USING btree ("id_bidang");
CREATE INDEX "bidang_dosen_fk" ON "bidang_dosen" USING btree ("nik_dosen");
CREATE UNIQUE INDEX "bidang_dosen_pk" ON "bidang_dosen" USING btree ("nik_dosen", "id_bidang");

-- ----------------------------
-- Primary Key structure for table "bidang_dosen"
-- ----------------------------
ALTER TABLE "bidang_dosen" ADD PRIMARY KEY ("nik_dosen", "id_bidang");

-- ----------------------------
-- Indexes structure for table dosen
-- ----------------------------
CREATE UNIQUE INDEX "dosen_pk" ON "dosen" USING btree ("nik_dosen");

-- ----------------------------
-- Primary Key structure for table "dosen"
-- ----------------------------
ALTER TABLE "dosen" ADD PRIMARY KEY ("nik_dosen");

-- ----------------------------
-- Primary Key structure for table "jadwal_detail"
-- ----------------------------
ALTER TABLE "jadwal_detail" ADD PRIMARY KEY ("id_slot");

-- ----------------------------
-- Primary Key structure for table "jam_kuliah_hari"
-- ----------------------------
ALTER TABLE "jam_kuliah_hari" ADD PRIMARY KEY ("id_jam");

-- ----------------------------
-- Indexes structure for table jdwl_smn_sdg
-- ----------------------------
CREATE UNIQUE INDEX "jdwl_smn_sdg_pk" ON "jdwl_smn_sdg" USING btree ("id_jdw_ss");
CREATE INDEX "relationship_10_fk" ON "jdwl_smn_sdg" USING btree ("id_periode");
CREATE INDEX "relationship_7_fk" ON "jdwl_smn_sdg" USING btree ("id_smnsdg");

-- ----------------------------
-- Primary Key structure for table "jdwl_smn_sdg"
-- ----------------------------
ALTER TABLE "jdwl_smn_sdg" ADD PRIMARY KEY ("id_jdw_ss");

-- ----------------------------
-- Indexes structure for table jenis_ka
-- ----------------------------
CREATE UNIQUE INDEX "jenis_ka_pk" ON "jenis_ka" USING btree ("id_jenis_ka");

-- ----------------------------
-- Primary Key structure for table "jenis_ka"
-- ----------------------------
ALTER TABLE "jenis_ka" ADD PRIMARY KEY ("id_jenis_ka");

-- ----------------------------
-- Indexes structure for table ka_topik
-- ----------------------------
CREATE INDEX "ka_topik2_fk" ON "ka_topik" USING btree ("id_topik");
CREATE INDEX "ka_topik_fk" ON "ka_topik" USING btree ("id_ka");
CREATE UNIQUE INDEX "ka_topik_pk" ON "ka_topik" USING btree ("id_ka", "id_topik");

-- ----------------------------
-- Primary Key structure for table "ka_topik"
-- ----------------------------
ALTER TABLE "ka_topik" ADD PRIMARY KEY ("id_ka", "id_topik");

-- ----------------------------
-- Indexes structure for table karya_akhir
-- ----------------------------
CREATE UNIQUE INDEX "karya_akhir_pk" ON "karya_akhir" USING btree ("id_ka");
CREATE INDEX "relationship_15_fk" ON "karya_akhir" USING btree ("id_jenis_ka");
CREATE INDEX "relationship_1_fk" ON "karya_akhir" USING btree ("nim");

-- ----------------------------
-- Primary Key structure for table "karya_akhir"
-- ----------------------------
ALTER TABLE "karya_akhir" ADD PRIMARY KEY ("id_ka");

-- ----------------------------
-- Indexes structure for table ketersediaan_dosen
-- ----------------------------
CREATE INDEX "dosen_ketersediaan_fk" ON "ketersediaan_dosen" USING btree ("nik_dosen");
CREATE UNIQUE INDEX "ketersediaandosen_pk" ON "ketersediaan_dosen" USING btree ("id_ketersediaan");

-- ----------------------------
-- Primary Key structure for table "ketersediaan_dosen"
-- ----------------------------
ALTER TABLE "ketersediaan_dosen" ADD PRIMARY KEY ("id_ketersediaan");

-- ----------------------------
-- Primary Key structure for table "ketersediaan_ruangan"
-- ----------------------------
ALTER TABLE "ketersediaan_ruangan" ADD PRIMARY KEY ("id_ket_ruangan");

-- ----------------------------
-- Indexes structure for table koordinator
-- ----------------------------
CREATE UNIQUE INDEX "koordinator_pk" ON "koordinator" USING btree ("id_koordinator");

-- ----------------------------
-- Primary Key structure for table "koordinator"
-- ----------------------------
ALTER TABLE "koordinator" ADD PRIMARY KEY ("id_koordinator");

-- ----------------------------
-- Indexes structure for table mahasiswa
-- ----------------------------
CREATE UNIQUE INDEX "mahasiswa_pk" ON "mahasiswa" USING btree ("nim");
CREATE INDEX "relationship_2_fk" ON "mahasiswa" USING btree ("id_ka");

-- ----------------------------
-- Primary Key structure for table "mahasiswa"
-- ----------------------------
ALTER TABLE "mahasiswa" ADD PRIMARY KEY ("nim");

-- ----------------------------
-- Indexes structure for table pembimbing
-- ----------------------------
CREATE INDEX "pembimbing2_fk" ON "pembimbing" USING btree ("id_ka");
CREATE INDEX "pembimbing_fk" ON "pembimbing" USING btree ("nik_dosen");
CREATE UNIQUE INDEX "pembimbing_pk" ON "pembimbing" USING btree ("nik_dosen", "id_ka");

-- ----------------------------
-- Primary Key structure for table "pembimbing"
-- ----------------------------
ALTER TABLE "pembimbing" ADD PRIMARY KEY ("nik_dosen", "id_ka");

-- ----------------------------
-- Indexes structure for table penguji
-- ----------------------------
CREATE INDEX "penguji2_fk" ON "penguji" USING btree ("id_smnsdg");
CREATE INDEX "penguji_fk" ON "penguji" USING btree ("nik_dosen");
CREATE UNIQUE INDEX "penguji_pk" ON "penguji" USING btree ("nik_dosen", "id_smnsdg");

-- ----------------------------
-- Primary Key structure for table "penguji"
-- ----------------------------
ALTER TABLE "penguji" ADD PRIMARY KEY ("nik_dosen", "id_smnsdg");

-- ----------------------------
-- Indexes structure for table periode
-- ----------------------------
CREATE UNIQUE INDEX "periode_pk" ON "periode" USING btree ("id_periode");

-- ----------------------------
-- Primary Key structure for table "periode"
-- ----------------------------
ALTER TABLE "periode" ADD PRIMARY KEY ("id_periode");

-- ----------------------------
-- Indexes structure for table ruangan
-- ----------------------------
CREATE UNIQUE INDEX "ruangan_pk" ON "ruangan" USING btree ("id_ruangan");

-- ----------------------------
-- Primary Key structure for table "ruangan"
-- ----------------------------
ALTER TABLE "ruangan" ADD PRIMARY KEY ("id_ruangan");

-- ----------------------------
-- Indexes structure for table seminar
-- ----------------------------
CREATE INDEX "relationship_14_fk" ON "seminar" USING btree ("id_smnsdg");
CREATE UNIQUE INDEX "seminar_pk" ON "seminar" USING btree ("id_seminar");

-- ----------------------------
-- Primary Key structure for table "seminar"
-- ----------------------------
ALTER TABLE "seminar" ADD PRIMARY KEY ("id_seminar");

-- ----------------------------
-- Indexes structure for table seminar_sidang
-- ----------------------------
CREATE INDEX "relationship_12_fk" ON "seminar_sidang" USING btree ("id_ka");
CREATE INDEX "relationship_6_fk" ON "seminar_sidang" USING btree ("id_jdw_ss");
CREATE UNIQUE INDEX "seminar_sidang_pk" ON "seminar_sidang" USING btree ("id_smnsdg");

-- ----------------------------
-- Primary Key structure for table "seminar_sidang"
-- ----------------------------
ALTER TABLE "seminar_sidang" ADD PRIMARY KEY ("id_smnsdg");

-- ----------------------------
-- Indexes structure for table sidang
-- ----------------------------
CREATE INDEX "relationship_13_fk" ON "sidang" USING btree ("id_smnsdg");
CREATE UNIQUE INDEX "sidang_pk" ON "sidang" USING btree ("id_sidang");

-- ----------------------------
-- Primary Key structure for table "sidang"
-- ----------------------------
ALTER TABLE "sidang" ADD PRIMARY KEY ("id_sidang");

-- ----------------------------
-- Indexes structure for table topik
-- ----------------------------
CREATE UNIQUE INDEX "topik_pk" ON "topik" USING btree ("id_topik");

-- ----------------------------
-- Primary Key structure for table "topik"
-- ----------------------------
ALTER TABLE "topik" ADD PRIMARY KEY ("id_topik");

-- ----------------------------
-- Foreign Key structure for table "bidang_dosen"
-- ----------------------------
ALTER TABLE "bidang_dosen" ADD FOREIGN KEY ("id_bidang") REFERENCES "topik" ("id_topik") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "bidang_dosen" ADD FOREIGN KEY ("nik_dosen") REFERENCES "dosen" ("nik_dosen") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "jadwal_detail"
-- ----------------------------
ALTER TABLE "jadwal_detail" ADD FOREIGN KEY ("id_jdwl_ss") REFERENCES "jdwl_smn_sdg" ("id_jdw_ss") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "jadwal_detail" ADD FOREIGN KEY ("id_jam") REFERENCES "jam_kuliah_hari" ("id_jam") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "jadwal_detail" ADD FOREIGN KEY ("id_ruangan") REFERENCES "ruangan" ("id_ruangan") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "jdwl_smn_sdg"
-- ----------------------------
ALTER TABLE "jdwl_smn_sdg" ADD FOREIGN KEY ("id_smnsdg") REFERENCES "seminar_sidang" ("id_smnsdg") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "jdwl_smn_sdg" ADD FOREIGN KEY ("id_periode") REFERENCES "periode" ("id_periode") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "ka_topik"
-- ----------------------------
ALTER TABLE "ka_topik" ADD FOREIGN KEY ("id_topik") REFERENCES "topik" ("id_topik") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "ka_topik" ADD FOREIGN KEY ("id_ka") REFERENCES "karya_akhir" ("id_ka") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "karya_akhir"
-- ----------------------------
ALTER TABLE "karya_akhir" ADD FOREIGN KEY ("nim") REFERENCES "mahasiswa" ("nim") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "karya_akhir" ADD FOREIGN KEY ("id_jenis_ka") REFERENCES "jenis_ka" ("id_jenis_ka") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "ketersediaan_dosen"
-- ----------------------------
ALTER TABLE "ketersediaan_dosen" ADD FOREIGN KEY ("id_jam") REFERENCES "jam_kuliah_hari" ("id_jam") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "ketersediaan_dosen" ADD FOREIGN KEY ("nik_dosen") REFERENCES "dosen" ("nik_dosen") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "ketersediaan_ruangan"
-- ----------------------------
ALTER TABLE "ketersediaan_ruangan" ADD FOREIGN KEY ("id_jam") REFERENCES "jam_kuliah_hari" ("id_jam") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "ketersediaan_ruangan" ADD FOREIGN KEY ("id_ruangan") REFERENCES "ruangan" ("id_ruangan") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "koordinator"
-- ----------------------------
ALTER TABLE "koordinator" ADD FOREIGN KEY ("nik_dosen") REFERENCES "dosen" ("nik_dosen") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "mahasiswa"
-- ----------------------------
ALTER TABLE "mahasiswa" ADD FOREIGN KEY ("id_ka") REFERENCES "karya_akhir" ("id_ka") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "pembimbing"
-- ----------------------------
ALTER TABLE "pembimbing" ADD FOREIGN KEY ("id_ka") REFERENCES "karya_akhir" ("id_ka") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "pembimbing" ADD FOREIGN KEY ("nik_dosen") REFERENCES "dosen" ("nik_dosen") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "penguji"
-- ----------------------------
ALTER TABLE "penguji" ADD FOREIGN KEY ("id_smnsdg") REFERENCES "seminar_sidang" ("id_smnsdg") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "penguji" ADD FOREIGN KEY ("nik_dosen") REFERENCES "dosen" ("nik_dosen") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "seminar"
-- ----------------------------
ALTER TABLE "seminar" ADD FOREIGN KEY ("id_smnsdg") REFERENCES "seminar_sidang" ("id_smnsdg") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "seminar_sidang"
-- ----------------------------
ALTER TABLE "seminar_sidang" ADD FOREIGN KEY ("id_jdw_ss") REFERENCES "jdwl_smn_sdg" ("id_jdw_ss") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "seminar_sidang" ADD FOREIGN KEY ("id_ka") REFERENCES "karya_akhir" ("id_ka") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Key structure for table "sidang"
-- ----------------------------
ALTER TABLE "sidang" ADD FOREIGN KEY ("id_smnsdg") REFERENCES "seminar_sidang" ("id_smnsdg") ON DELETE RESTRICT ON UPDATE RESTRICT;
