--
-- PostgreSQL database dump
--

\restrict XOGdKc06cdTWdJAjxaAh1feTrTudi4cu91bIHVlmroY9CePfaNmy73N5V7Fv2h5

-- Dumped from database version 18.1
-- Dumped by pg_dump version 18.1

-- Started on 2026-03-07 18:19:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 244 (class 1259 OID 16559)
-- Name: activity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.activity (
    activity_id integer NOT NULL,
    trip_id integer,
    activity_name character varying(100),
    location character varying(100),
    activity_date date,
    duration_hours integer,
    costs numeric(10,2),
    booking_status character varying(50),
    booking_reference character varying(100),
    notes text
);


ALTER TABLE public.activity OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 16558)
-- Name: activity_activity_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.activity_activity_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.activity_activity_id_seq OWNER TO postgres;

--
-- TOC entry 5221 (class 0 OID 0)
-- Dependencies: 243
-- Name: activity_activity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.activity_activity_id_seq OWNED BY public.activity.activity_id;


--
-- TOC entry 219 (class 1259 OID 16389)
-- Name: agent_assignment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.agent_assignment (
    assignment_id integer NOT NULL,
    trip_id integer,
    agent_id integer,
    assigned_date date
);


ALTER TABLE public.agent_assignment OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16393)
-- Name: agent_assignment_assignment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.agent_assignment_assignment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.agent_assignment_assignment_id_seq OWNER TO postgres;

--
-- TOC entry 5222 (class 0 OID 0)
-- Dependencies: 220
-- Name: agent_assignment_assignment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.agent_assignment_assignment_id_seq OWNED BY public.agent_assignment.assignment_id;


--
-- TOC entry 221 (class 1259 OID 16394)
-- Name: agents; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.agents (
    agent_id integer NOT NULL,
    agent_name character varying(100),
    phone character varying(15),
    email character varying(100),
    experience_years integer,
    languages_known character varying(100)
);


ALTER TABLE public.agents OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16398)
-- Name: agents_agent_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.agents_agent_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.agents_agent_id_seq OWNER TO postgres;

--
-- TOC entry 5223 (class 0 OID 0)
-- Dependencies: 222
-- Name: agents_agent_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.agents_agent_id_seq OWNED BY public.agents.agent_id;


--
-- TOC entry 223 (class 1259 OID 16399)
-- Name: backup_plans; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.backup_plans (
    backup_id integer NOT NULL,
    trip_id integer,
    trigger_reason character varying(50),
    alternative_plan text
);


ALTER TABLE public.backup_plans OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16405)
-- Name: backup_plans_backup_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.backup_plans_backup_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.backup_plans_backup_id_seq OWNER TO postgres;

--
-- TOC entry 5224 (class 0 OID 0)
-- Dependencies: 224
-- Name: backup_plans_backup_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.backup_plans_backup_id_seq OWNED BY public.backup_plans.backup_id;


--
-- TOC entry 225 (class 1259 OID 16406)
-- Name: bookings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bookings (
    booking_id integer NOT NULL,
    user_id integer,
    trip_id integer,
    booking_date date,
    booking_status character varying(20),
    solo_traveler boolean,
    compatibility_score integer
);


ALTER TABLE public.bookings OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16410)
-- Name: bookings_booking_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bookings_booking_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.bookings_booking_id_seq OWNER TO postgres;

--
-- TOC entry 5225 (class 0 OID 0)
-- Dependencies: 226
-- Name: bookings_booking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bookings_booking_id_seq OWNED BY public.bookings.booking_id;


--
-- TOC entry 227 (class 1259 OID 16411)
-- Name: destinations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.destinations (
    destination_id integer NOT NULL,
    destination_name character varying(100) NOT NULL,
    state character varying(50),
    country character varying(50),
    climate character varying(30),
    best_season character varying(30),
    crowd_level character varying(20)
);


ALTER TABLE public.destinations OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16416)
-- Name: destinations_destination_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.destinations_destination_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.destinations_destination_id_seq OWNER TO postgres;

--
-- TOC entry 5226 (class 0 OID 0)
-- Dependencies: 228
-- Name: destinations_destination_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.destinations_destination_id_seq OWNED BY public.destinations.destination_id;


--
-- TOC entry 254 (class 1259 OID 16630)
-- Name: expense; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expense (
    expense_id integer NOT NULL,
    trip_id integer,
    transport_cost numeric(10,2),
    hotel_cost numeric(10,2),
    food_cost numeric(10,2),
    miscellaneous_cost numeric(10,2),
    total_cost numeric(10,2),
    last_updated timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.expense OWNER TO postgres;

--
-- TOC entry 253 (class 1259 OID 16629)
-- Name: expense_expense_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.expense_expense_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.expense_expense_id_seq OWNER TO postgres;

--
-- TOC entry 5227 (class 0 OID 0)
-- Dependencies: 253
-- Name: expense_expense_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.expense_expense_id_seq OWNED BY public.expense.expense_id;


--
-- TOC entry 252 (class 1259 OID 16614)
-- Name: food; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.food (
    food_id integer NOT NULL,
    trip_id integer,
    food_type character varying(50),
    restaurant_name character varying(100),
    meal_date date,
    cuisine_type character varying(50),
    cost numeric(10,2)
);


ALTER TABLE public.food OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 16613)
-- Name: food_food_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.food_food_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.food_food_id_seq OWNER TO postgres;

--
-- TOC entry 5228 (class 0 OID 0)
-- Dependencies: 251
-- Name: food_food_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.food_food_id_seq OWNED BY public.food.food_id;


--
-- TOC entry 250 (class 1259 OID 16601)
-- Name: hotel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel (
    hotel_id integer NOT NULL,
    trip_id integer,
    hotel_name character varying(100),
    city character varying(50),
    address character varying(200),
    star_rating integer,
    cost_per_night numeric(10,2),
    total_days integer,
    total_hotel_cost numeric(10,2)
);


ALTER TABLE public.hotel OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 16600)
-- Name: hotel_hotel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hotel_hotel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.hotel_hotel_id_seq OWNER TO postgres;

--
-- TOC entry 5229 (class 0 OID 0)
-- Dependencies: 249
-- Name: hotel_hotel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hotel_hotel_id_seq OWNED BY public.hotel.hotel_id;


--
-- TOC entry 229 (class 1259 OID 16417)
-- Name: parent_guardian_view; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parent_guardian_view (
    guardian_id integer NOT NULL,
    user_id integer,
    guardian_name character varying(100),
    phone character varying(15),
    relationship character varying(30)
);


ALTER TABLE public.parent_guardian_view OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16421)
-- Name: parent_guardian_view_guardian_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.parent_guardian_view_guardian_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.parent_guardian_view_guardian_id_seq OWNER TO postgres;

--
-- TOC entry 5230 (class 0 OID 0)
-- Dependencies: 230
-- Name: parent_guardian_view_guardian_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.parent_guardian_view_guardian_id_seq OWNED BY public.parent_guardian_view.guardian_id;


--
-- TOC entry 246 (class 1259 OID 16575)
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    payment_id integer NOT NULL,
    trip_id integer,
    payment_method character varying(50),
    payment_status character varying(50),
    payment_date date,
    amount numeric(10,2),
    refund numeric(10,2)
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 16574)
-- Name: payment_payment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.payment_payment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.payment_payment_id_seq OWNER TO postgres;

--
-- TOC entry 5231 (class 0 OID 0)
-- Dependencies: 245
-- Name: payment_payment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.payment_payment_id_seq OWNED BY public.payment.payment_id;


--
-- TOC entry 231 (class 1259 OID 16422)
-- Name: silent_support_requests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.silent_support_requests (
    request_id integer NOT NULL,
    booking_id integer,
    request_type character varying(30),
    message text,
    request_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.silent_support_requests OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16429)
-- Name: silent_support_requests_request_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.silent_support_requests_request_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.silent_support_requests_request_id_seq OWNER TO postgres;

--
-- TOC entry 5232 (class 0 OID 0)
-- Dependencies: 232
-- Name: silent_support_requests_request_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.silent_support_requests_request_id_seq OWNED BY public.silent_support_requests.request_id;


--
-- TOC entry 233 (class 1259 OID 16430)
-- Name: special_needs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.special_needs (
    need_id integer NOT NULL,
    user_id integer,
    medical_condition text,
    food_preference character varying(50),
    physical_limitations text,
    emergency_contact character varying(15)
);


ALTER TABLE public.special_needs OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 16436)
-- Name: special_needs_need_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.special_needs_need_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.special_needs_need_id_seq OWNER TO postgres;

--
-- TOC entry 5233 (class 0 OID 0)
-- Dependencies: 234
-- Name: special_needs_need_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.special_needs_need_id_seq OWNED BY public.special_needs.need_id;


--
-- TOC entry 248 (class 1259 OID 16588)
-- Name: transport; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transport (
    transport_id integer NOT NULL,
    trip_id integer,
    transport_mode character varying(50),
    provider_name character varying(100),
    vehicle_number character varying(50),
    departure_time timestamp without time zone,
    arrival_time timestamp without time zone,
    cost numeric(10,2)
);


ALTER TABLE public.transport OWNER TO postgres;

--
-- TOC entry 247 (class 1259 OID 16587)
-- Name: transport_transport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transport_transport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.transport_transport_id_seq OWNER TO postgres;

--
-- TOC entry 5234 (class 0 OID 0)
-- Dependencies: 247
-- Name: transport_transport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transport_transport_id_seq OWNED BY public.transport.transport_id;


--
-- TOC entry 235 (class 1259 OID 16437)
-- Name: travel_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.travel_details (
    travel_id integer NOT NULL,
    trip_id integer,
    transport_mode character varying(30),
    source_city character varying(50),
    travel_duration_hours integer,
    travel_notes text
);


ALTER TABLE public.travel_details OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 16443)
-- Name: travel_details_travel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.travel_details_travel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.travel_details_travel_id_seq OWNER TO postgres;

--
-- TOC entry 5235 (class 0 OID 0)
-- Dependencies: 236
-- Name: travel_details_travel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.travel_details_travel_id_seq OWNED BY public.travel_details.travel_id;


--
-- TOC entry 237 (class 1259 OID 16444)
-- Name: trip_decision_log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trip_decision_log (
    decision_id integer NOT NULL,
    user_id integer,
    trip_id integer,
    reason text,
    decision_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.trip_decision_log OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 16451)
-- Name: trip_decision_log_decision_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trip_decision_log_decision_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.trip_decision_log_decision_id_seq OWNER TO postgres;

--
-- TOC entry 5236 (class 0 OID 0)
-- Dependencies: 238
-- Name: trip_decision_log_decision_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trip_decision_log_decision_id_seq OWNED BY public.trip_decision_log.decision_id;


--
-- TOC entry 256 (class 1259 OID 16644)
-- Name: trip_withdrawal_request; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trip_withdrawal_request (
    request_id integer NOT NULL,
    booking_id integer,
    user_id integer,
    trip_id integer,
    withdrawal_reason text,
    request_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    status character varying(30) DEFAULT 'PENDING'::character varying
);


ALTER TABLE public.trip_withdrawal_request OWNER TO postgres;

--
-- TOC entry 255 (class 1259 OID 16643)
-- Name: trip_withdrawal_request_request_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trip_withdrawal_request_request_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.trip_withdrawal_request_request_id_seq OWNER TO postgres;

--
-- TOC entry 5237 (class 0 OID 0)
-- Dependencies: 255
-- Name: trip_withdrawal_request_request_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trip_withdrawal_request_request_id_seq OWNED BY public.trip_withdrawal_request.request_id;


--
-- TOC entry 239 (class 1259 OID 16452)
-- Name: trips; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trips (
    trip_id integer NOT NULL,
    trip_title character varying(100),
    destination character varying(100),
    trip_type character varying(30),
    purpose_of_travel character varying(30),
    suitable_age_group character varying(30),
    season character varying(20),
    pace_level character varying(20),
    risk_level character varying(10),
    start_date date,
    end_date date,
    max_capacity integer
);


ALTER TABLE public.trips OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 16456)
-- Name: trips_trip_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trips_trip_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.trips_trip_id_seq OWNER TO postgres;

--
-- TOC entry 5238 (class 0 OID 0)
-- Dependencies: 240
-- Name: trips_trip_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trips_trip_id_seq OWNED BY public.trips.trip_id;


--
-- TOC entry 241 (class 1259 OID 16457)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    full_name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(15),
    age integer,
    gender character varying(10),
    life_stage character varying(20),
    travel_personality character varying(20),
    travel_confidence character varying(10),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 16464)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO postgres;

--
-- TOC entry 5239 (class 0 OID 0)
-- Dependencies: 242
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 4961 (class 2604 OID 16562)
-- Name: activity activity_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activity ALTER COLUMN activity_id SET DEFAULT nextval('public.activity_activity_id_seq'::regclass);


--
-- TOC entry 4946 (class 2604 OID 16465)
-- Name: agent_assignment assignment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agent_assignment ALTER COLUMN assignment_id SET DEFAULT nextval('public.agent_assignment_assignment_id_seq'::regclass);


--
-- TOC entry 4947 (class 2604 OID 16466)
-- Name: agents agent_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agents ALTER COLUMN agent_id SET DEFAULT nextval('public.agents_agent_id_seq'::regclass);


--
-- TOC entry 4948 (class 2604 OID 16467)
-- Name: backup_plans backup_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.backup_plans ALTER COLUMN backup_id SET DEFAULT nextval('public.backup_plans_backup_id_seq'::regclass);


--
-- TOC entry 4949 (class 2604 OID 16468)
-- Name: bookings booking_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings ALTER COLUMN booking_id SET DEFAULT nextval('public.bookings_booking_id_seq'::regclass);


--
-- TOC entry 4950 (class 2604 OID 16469)
-- Name: destinations destination_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.destinations ALTER COLUMN destination_id SET DEFAULT nextval('public.destinations_destination_id_seq'::regclass);


--
-- TOC entry 4966 (class 2604 OID 16633)
-- Name: expense expense_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense ALTER COLUMN expense_id SET DEFAULT nextval('public.expense_expense_id_seq'::regclass);


--
-- TOC entry 4965 (class 2604 OID 16617)
-- Name: food food_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food ALTER COLUMN food_id SET DEFAULT nextval('public.food_food_id_seq'::regclass);


--
-- TOC entry 4964 (class 2604 OID 16604)
-- Name: hotel hotel_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel ALTER COLUMN hotel_id SET DEFAULT nextval('public.hotel_hotel_id_seq'::regclass);


--
-- TOC entry 4951 (class 2604 OID 16470)
-- Name: parent_guardian_view guardian_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parent_guardian_view ALTER COLUMN guardian_id SET DEFAULT nextval('public.parent_guardian_view_guardian_id_seq'::regclass);


--
-- TOC entry 4962 (class 2604 OID 16578)
-- Name: payment payment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment ALTER COLUMN payment_id SET DEFAULT nextval('public.payment_payment_id_seq'::regclass);


--
-- TOC entry 4952 (class 2604 OID 16471)
-- Name: silent_support_requests request_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.silent_support_requests ALTER COLUMN request_id SET DEFAULT nextval('public.silent_support_requests_request_id_seq'::regclass);


--
-- TOC entry 4954 (class 2604 OID 16472)
-- Name: special_needs need_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.special_needs ALTER COLUMN need_id SET DEFAULT nextval('public.special_needs_need_id_seq'::regclass);


--
-- TOC entry 4963 (class 2604 OID 16591)
-- Name: transport transport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transport ALTER COLUMN transport_id SET DEFAULT nextval('public.transport_transport_id_seq'::regclass);


--
-- TOC entry 4955 (class 2604 OID 16473)
-- Name: travel_details travel_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.travel_details ALTER COLUMN travel_id SET DEFAULT nextval('public.travel_details_travel_id_seq'::regclass);


--
-- TOC entry 4956 (class 2604 OID 16474)
-- Name: trip_decision_log decision_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_decision_log ALTER COLUMN decision_id SET DEFAULT nextval('public.trip_decision_log_decision_id_seq'::regclass);


--
-- TOC entry 4968 (class 2604 OID 16647)
-- Name: trip_withdrawal_request request_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_withdrawal_request ALTER COLUMN request_id SET DEFAULT nextval('public.trip_withdrawal_request_request_id_seq'::regclass);


--
-- TOC entry 4958 (class 2604 OID 16475)
-- Name: trips trip_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trips ALTER COLUMN trip_id SET DEFAULT nextval('public.trips_trip_id_seq'::regclass);


--
-- TOC entry 4959 (class 2604 OID 16476)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 5203 (class 0 OID 16559)
-- Dependencies: 244
-- Data for Name: activity; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.activity VALUES (1, 1, 'Scuba Diving', 'Goa Beach', '2026-02-11', 3, 2500.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (2, 2, 'Snow Skiing', 'Manali', '2026-01-06', 4, 3000.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (3, 3, 'City Palace Tour', 'Jaipur', '2026-03-13', 2, 800.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (4, 4, 'Houseboat Ride', 'Kerala Backwaters', '2026-06-02', 5, 3500.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (5, 5, 'Bike Expedition', 'Ladakh', '2026-07-11', 8, 5000.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (6, 6, 'Tea Garden Walk', 'Darjeeling', '2026-04-06', 2, 500.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (7, 7, 'Snorkeling', 'Andaman Beach', '2026-02-21', 2, 2000.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (8, 8, 'River Rafting', 'Rishikesh', '2026-05-13', 3, 1800.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (9, 9, 'Boat Ride', 'Lake Pichola', '2026-03-06', 1, 700.00, NULL, NULL, NULL);
INSERT INTO public.activity VALUES (10, 10, 'Snow Trekking', 'Shimla', '2026-12-21', 4, 2200.00, NULL, NULL, NULL);


--
-- TOC entry 5178 (class 0 OID 16389)
-- Dependencies: 219
-- Data for Name: agent_assignment; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5180 (class 0 OID 16394)
-- Dependencies: 221
-- Data for Name: agents; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5182 (class 0 OID 16399)
-- Dependencies: 223
-- Data for Name: backup_plans; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5184 (class 0 OID 16406)
-- Dependencies: 225
-- Data for Name: bookings; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.bookings VALUES (1, 1, 1, '2026-02-01', 'CONFIRMED', NULL, NULL);
INSERT INTO public.bookings VALUES (2, 2, 2, '2026-01-01', 'CONFIRMED', NULL, NULL);
INSERT INTO public.bookings VALUES (3, 3, 3, '2026-03-01', 'PENDING', NULL, NULL);
INSERT INTO public.bookings VALUES (4, 4, 4, '2026-05-20', 'CONFIRMED', NULL, NULL);
INSERT INTO public.bookings VALUES (5, 5, 5, '2026-06-25', 'CONFIRMED', NULL, NULL);
INSERT INTO public.bookings VALUES (6, 6, 6, '2026-03-15', 'PENDING', NULL, NULL);
INSERT INTO public.bookings VALUES (7, 7, 7, '2026-02-18', 'CONFIRMED', NULL, NULL);
INSERT INTO public.bookings VALUES (8, 8, 8, '2026-05-10', 'CONFIRMED', NULL, NULL);
INSERT INTO public.bookings VALUES (9, 9, 9, '2026-03-01', 'PENDING', NULL, NULL);
INSERT INTO public.bookings VALUES (10, 10, 10, '2026-12-01', 'CONFIRMED', NULL, NULL);


--
-- TOC entry 5186 (class 0 OID 16411)
-- Dependencies: 227
-- Data for Name: destinations; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.destinations VALUES (1, 'Goa', NULL, 'India', NULL, 'Winter', NULL);
INSERT INTO public.destinations VALUES (2, 'Manali', NULL, 'India', NULL, 'Winter', NULL);
INSERT INTO public.destinations VALUES (3, 'Jaipur', NULL, 'India', NULL, 'Winter', NULL);
INSERT INTO public.destinations VALUES (4, 'Kerala', NULL, 'India', NULL, 'Monsoon', NULL);
INSERT INTO public.destinations VALUES (5, 'Ladakh', NULL, 'India', NULL, 'Summer', NULL);
INSERT INTO public.destinations VALUES (6, 'Darjeeling', NULL, 'India', NULL, 'Spring', NULL);
INSERT INTO public.destinations VALUES (7, 'Andaman', NULL, 'India', NULL, 'Winter', NULL);
INSERT INTO public.destinations VALUES (8, 'Rishikesh', NULL, 'India', NULL, 'Summer', NULL);
INSERT INTO public.destinations VALUES (9, 'Udaipur', NULL, 'India', NULL, 'Winter', NULL);
INSERT INTO public.destinations VALUES (10, 'Shimla', NULL, 'India', NULL, 'Winter', NULL);


--
-- TOC entry 5213 (class 0 OID 16630)
-- Dependencies: 254
-- Data for Name: expense; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.expense VALUES (1, 1, 5000.00, 12000.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (2, 2, 4500.00, 10000.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (3, 3, 3000.00, 9000.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (4, 4, 7000.00, 14000.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (5, 5, 6000.00, 13000.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (6, 6, 3500.00, 9500.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (7, 7, 8000.00, 15000.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (8, 8, 3200.00, 9000.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (9, 9, 2800.00, 8500.00, NULL, NULL, NULL, NULL);
INSERT INTO public.expense VALUES (10, 10, 4000.00, 10000.00, NULL, NULL, NULL, NULL);


--
-- TOC entry 5211 (class 0 OID 16614)
-- Dependencies: 252
-- Data for Name: food; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.food VALUES (1, 1, 'Seafood', 'Goa Spice Restaurant', NULL, NULL, NULL);
INSERT INTO public.food VALUES (2, 2, 'North Indian', 'Manali Cafe', NULL, NULL, NULL);
INSERT INTO public.food VALUES (3, 3, 'Rajasthani', 'Jaipur Royal Kitchen', NULL, NULL, NULL);
INSERT INTO public.food VALUES (4, 4, 'South Indian', 'Kerala Spice House', NULL, NULL, NULL);
INSERT INTO public.food VALUES (5, 5, 'Tibetan', 'Ladakh Mountain Cafe', NULL, NULL, NULL);
INSERT INTO public.food VALUES (6, 6, 'Cafe', 'Darjeeling Tea Lounge', NULL, NULL, NULL);
INSERT INTO public.food VALUES (7, 7, 'Seafood', 'Island Seafood Shack', NULL, NULL, NULL);
INSERT INTO public.food VALUES (8, 8, 'Indian', 'Rafting Camp Kitchen', NULL, NULL, NULL);
INSERT INTO public.food VALUES (9, 9, 'Multi-cuisine', 'Lakeview Dining', NULL, NULL, NULL);
INSERT INTO public.food VALUES (10, 10, 'Cafe', 'Shimla Snow Cafe', NULL, NULL, NULL);


--
-- TOC entry 5209 (class 0 OID 16601)
-- Dependencies: 250
-- Data for Name: hotel; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.hotel VALUES (1, 1, 'Sea View Resort', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (2, 2, 'Snow Valley Hotel', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (3, 3, 'Royal Heritage Hotel', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (4, 4, 'Backwater Resort', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (5, 5, 'Mountain View Lodge', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (6, 6, 'Tea Garden Resort', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (7, 7, 'Island Paradise Resort', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (8, 8, 'Adventure Camp Resort', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (9, 9, 'Lake Palace Hotel', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.hotel VALUES (10, 10, 'Snow Peak Hotel', NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 5188 (class 0 OID 16417)
-- Dependencies: 229
-- Data for Name: parent_guardian_view; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5205 (class 0 OID 16575)
-- Dependencies: 246
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.payment VALUES (1, NULL, 'Credit Card', 'PAID', NULL, 15000.00, NULL);
INSERT INTO public.payment VALUES (2, NULL, 'UPI', 'PAID', NULL, 12000.00, NULL);
INSERT INTO public.payment VALUES (3, NULL, 'Debit Card', 'PENDING', NULL, 10000.00, NULL);
INSERT INTO public.payment VALUES (4, NULL, 'Credit Card', 'PAID', NULL, 18000.00, NULL);
INSERT INTO public.payment VALUES (5, NULL, 'UPI', 'PAID', NULL, 20000.00, NULL);
INSERT INTO public.payment VALUES (6, NULL, 'Debit Card', 'PENDING', NULL, 13000.00, NULL);
INSERT INTO public.payment VALUES (7, NULL, 'Credit Card', 'PAID', NULL, 17000.00, NULL);
INSERT INTO public.payment VALUES (8, NULL, 'UPI', 'PAID', NULL, 11000.00, NULL);
INSERT INTO public.payment VALUES (9, NULL, 'Debit Card', 'PENDING', NULL, 14000.00, NULL);
INSERT INTO public.payment VALUES (10, NULL, 'Credit Card', 'PAID', NULL, 16000.00, NULL);


--
-- TOC entry 5190 (class 0 OID 16422)
-- Dependencies: 231
-- Data for Name: silent_support_requests; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5192 (class 0 OID 16430)
-- Dependencies: 233
-- Data for Name: special_needs; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5207 (class 0 OID 16588)
-- Dependencies: 248
-- Data for Name: transport; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.transport VALUES (1, 1, NULL, NULL, NULL, NULL, NULL, 1500.00);
INSERT INTO public.transport VALUES (2, 2, NULL, NULL, NULL, NULL, NULL, 1800.00);
INSERT INTO public.transport VALUES (3, 3, NULL, NULL, NULL, NULL, NULL, 1200.00);
INSERT INTO public.transport VALUES (4, 4, NULL, NULL, NULL, NULL, NULL, 6000.00);
INSERT INTO public.transport VALUES (5, 5, NULL, NULL, NULL, NULL, NULL, 3500.00);
INSERT INTO public.transport VALUES (6, 6, NULL, NULL, NULL, NULL, NULL, 900.00);
INSERT INTO public.transport VALUES (7, 7, NULL, NULL, NULL, NULL, NULL, 8000.00);
INSERT INTO public.transport VALUES (8, 8, NULL, NULL, NULL, NULL, NULL, 1100.00);
INSERT INTO public.transport VALUES (9, 9, NULL, NULL, NULL, NULL, NULL, 1300.00);
INSERT INTO public.transport VALUES (10, 10, NULL, NULL, NULL, NULL, NULL, 1400.00);


--
-- TOC entry 5194 (class 0 OID 16437)
-- Dependencies: 235
-- Data for Name: travel_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.travel_details VALUES (3, NULL, 'Train', 'Delhi', NULL, NULL);
INSERT INTO public.travel_details VALUES (4, NULL, 'Flight', 'Mumbai', NULL, NULL);
INSERT INTO public.travel_details VALUES (5, NULL, 'Bike', 'Manali', NULL, NULL);
INSERT INTO public.travel_details VALUES (6, NULL, 'Train', 'Kolkata', NULL, NULL);
INSERT INTO public.travel_details VALUES (7, NULL, 'Flight', 'Chennai', NULL, NULL);
INSERT INTO public.travel_details VALUES (8, NULL, 'Bus', 'Delhi', NULL, NULL);
INSERT INTO public.travel_details VALUES (9, NULL, 'Train', 'Ahmedabad', NULL, NULL);
INSERT INTO public.travel_details VALUES (10, NULL, 'Bus', 'Chennai', NULL, NULL);
INSERT INTO public.travel_details VALUES (1, 1, 'Flight', 'Delhi', 2, 'Flight journey from Delhi to Goa');
INSERT INTO public.travel_details VALUES (2, 2, 'Volvo Bus', 'Chandigarh', 8, 'Overnight Volvo bus from Chandigarh');


--
-- TOC entry 5196 (class 0 OID 16444)
-- Dependencies: 237
-- Data for Name: trip_decision_log; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5215 (class 0 OID 16644)
-- Dependencies: 256
-- Data for Name: trip_withdrawal_request; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5198 (class 0 OID 16452)
-- Dependencies: 239
-- Data for Name: trips; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.trips VALUES (1, 'Goa Beach Vacation', 'Goa', 'Leisure', 'Vacation', '18-35', 'Winter', 'Relaxed', 'Low', '2026-02-10', '2026-02-15', 20);
INSERT INTO public.trips VALUES (2, 'Manali Snow Adventure', 'Manali', 'Adventure', 'Exploration', '18-40', 'Winter', 'Moderate', 'Medium', '2026-01-05', '2026-01-10', 15);
INSERT INTO public.trips VALUES (3, 'Jaipur Heritage Tour', 'Jaipur', 'Cultural', 'Heritage', '20-50', 'Winter', 'Relaxed', 'Low', '2026-03-12', '2026-03-16', 25);
INSERT INTO public.trips VALUES (4, 'Kerala Backwater Experience', 'Kerala', 'Leisure', 'Nature', '18-45', 'Monsoon', 'Relaxed', 'Low', '2026-06-01', '2026-06-06', 20);
INSERT INTO public.trips VALUES (5, 'Ladakh Bike Expedition', 'Ladakh', 'Adventure', 'Road Trip', '21-40', 'Summer', 'Fast', 'High', '2026-07-10', '2026-07-18', 12);
INSERT INTO public.trips VALUES (6, 'Darjeeling Tea Garden Tour', 'Darjeeling', 'Leisure', 'Relaxation', '20-50', 'Spring', 'Relaxed', 'Low', '2026-04-05', '2026-04-10', 18);
INSERT INTO public.trips VALUES (7, 'Andaman Island Escape', 'Andaman', 'Leisure', 'Vacation', '18-40', 'Winter', 'Relaxed', 'Low', '2026-02-20', '2026-02-25', 20);
INSERT INTO public.trips VALUES (8, 'Rishikesh Adventure Camp', 'Rishikesh', 'Adventure', 'Rafting', '18-35', 'Summer', 'Fast', 'Medium', '2026-05-12', '2026-05-15', 16);
INSERT INTO public.trips VALUES (9, 'Udaipur Lake Tour', 'Udaipur', 'Leisure', 'Sightseeing', '18-50', 'Winter', 'Relaxed', 'Low', '2026-03-05', '2026-03-08', 22);
INSERT INTO public.trips VALUES (10, 'Shimla Snow Escape', 'Shimla', 'Leisure', 'Holiday', '18-40', 'Winter', 'Relaxed', 'Low', '2026-12-20', '2026-12-25', 20);


--
-- TOC entry 5200 (class 0 OID 16457)
-- Dependencies: 241
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (1, 'Neha Nupur', 'neha@gmail.com', '9898989898', 22, 'Female', NULL, NULL, NULL, '2026-03-07 13:49:25.820067');
INSERT INTO public.users VALUES (2, 'Rohan Sharma', 'rohan@gmail.com', '9876543210', 25, 'Male', NULL, NULL, NULL, '2026-03-07 13:49:35.809457');
INSERT INTO public.users VALUES (3, 'Aditi Singh', 'aditi@gmail.com', '9123456789', 23, 'Female', NULL, NULL, NULL, '2026-03-07 13:49:45.991037');
INSERT INTO public.users VALUES (4, 'Arjun Verma', 'arjun@gmail.com', '9000000001', 27, 'Male', NULL, NULL, NULL, '2026-03-07 13:50:00.671441');
INSERT INTO public.users VALUES (5, 'Priya Mehta', 'priya@gmail.com', '9000000002', 24, 'Female', NULL, NULL, NULL, '2026-03-07 13:50:09.193055');
INSERT INTO public.users VALUES (6, 'Rahul Kapoor', 'rahul@gmail.com', '9000000003', 28, 'Male', NULL, NULL, NULL, '2026-03-07 13:50:19.093993');
INSERT INTO public.users VALUES (7, 'Sneha Gupta', 'sneha@gmail.com', '9000000004', 21, 'Female', NULL, NULL, NULL, '2026-03-07 13:50:31.210429');
INSERT INTO public.users VALUES (8, 'Karan Patel', 'karan@gmail.com', '9000000005', 26, 'Male', NULL, NULL, NULL, '2026-03-07 13:50:42.099832');
INSERT INTO public.users VALUES (9, 'Simran Kaur', 'simran@gmail.com', '9000000006', 23, 'Female', NULL, NULL, NULL, '2026-03-07 13:50:48.924403');
INSERT INTO public.users VALUES (10, 'Aman Singh', 'aman@gmail.com', '9000000007', 29, 'Male', NULL, NULL, NULL, '2026-03-07 13:50:56.904664');


--
-- TOC entry 5240 (class 0 OID 0)
-- Dependencies: 243
-- Name: activity_activity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.activity_activity_id_seq', 10, true);


--
-- TOC entry 5241 (class 0 OID 0)
-- Dependencies: 220
-- Name: agent_assignment_assignment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.agent_assignment_assignment_id_seq', 1, false);


--
-- TOC entry 5242 (class 0 OID 0)
-- Dependencies: 222
-- Name: agents_agent_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.agents_agent_id_seq', 1, false);


--
-- TOC entry 5243 (class 0 OID 0)
-- Dependencies: 224
-- Name: backup_plans_backup_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.backup_plans_backup_id_seq', 1, false);


--
-- TOC entry 5244 (class 0 OID 0)
-- Dependencies: 226
-- Name: bookings_booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bookings_booking_id_seq', 10, true);


--
-- TOC entry 5245 (class 0 OID 0)
-- Dependencies: 228
-- Name: destinations_destination_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.destinations_destination_id_seq', 10, true);


--
-- TOC entry 5246 (class 0 OID 0)
-- Dependencies: 253
-- Name: expense_expense_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.expense_expense_id_seq', 10, true);


--
-- TOC entry 5247 (class 0 OID 0)
-- Dependencies: 251
-- Name: food_food_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.food_food_id_seq', 10, true);


--
-- TOC entry 5248 (class 0 OID 0)
-- Dependencies: 249
-- Name: hotel_hotel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 10, true);


--
-- TOC entry 5249 (class 0 OID 0)
-- Dependencies: 230
-- Name: parent_guardian_view_guardian_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.parent_guardian_view_guardian_id_seq', 1, false);


--
-- TOC entry 5250 (class 0 OID 0)
-- Dependencies: 245
-- Name: payment_payment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.payment_payment_id_seq', 10, true);


--
-- TOC entry 5251 (class 0 OID 0)
-- Dependencies: 232
-- Name: silent_support_requests_request_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.silent_support_requests_request_id_seq', 1, false);


--
-- TOC entry 5252 (class 0 OID 0)
-- Dependencies: 234
-- Name: special_needs_need_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.special_needs_need_id_seq', 1, false);


--
-- TOC entry 5253 (class 0 OID 0)
-- Dependencies: 247
-- Name: transport_transport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transport_transport_id_seq', 10, true);


--
-- TOC entry 5254 (class 0 OID 0)
-- Dependencies: 236
-- Name: travel_details_travel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.travel_details_travel_id_seq', 10, true);


--
-- TOC entry 5255 (class 0 OID 0)
-- Dependencies: 238
-- Name: trip_decision_log_decision_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trip_decision_log_decision_id_seq', 1, false);


--
-- TOC entry 5256 (class 0 OID 0)
-- Dependencies: 255
-- Name: trip_withdrawal_request_request_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trip_withdrawal_request_request_id_seq', 1, false);


--
-- TOC entry 5257 (class 0 OID 0)
-- Dependencies: 240
-- Name: trips_trip_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trips_trip_id_seq', 10, true);


--
-- TOC entry 5258 (class 0 OID 0)
-- Dependencies: 242
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 10, true);


--
-- TOC entry 4998 (class 2606 OID 16567)
-- Name: activity activity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activity
    ADD CONSTRAINT activity_pkey PRIMARY KEY (activity_id);


--
-- TOC entry 4972 (class 2606 OID 16478)
-- Name: agent_assignment agent_assignment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agent_assignment
    ADD CONSTRAINT agent_assignment_pkey PRIMARY KEY (assignment_id);


--
-- TOC entry 4974 (class 2606 OID 16480)
-- Name: agents agents_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agents
    ADD CONSTRAINT agents_pkey PRIMARY KEY (agent_id);


--
-- TOC entry 4976 (class 2606 OID 16482)
-- Name: backup_plans backup_plans_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.backup_plans
    ADD CONSTRAINT backup_plans_pkey PRIMARY KEY (backup_id);


--
-- TOC entry 4978 (class 2606 OID 16484)
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (booking_id);


--
-- TOC entry 4980 (class 2606 OID 16486)
-- Name: destinations destinations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.destinations
    ADD CONSTRAINT destinations_pkey PRIMARY KEY (destination_id);


--
-- TOC entry 5008 (class 2606 OID 16637)
-- Name: expense expense_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense
    ADD CONSTRAINT expense_pkey PRIMARY KEY (expense_id);


--
-- TOC entry 5006 (class 2606 OID 16620)
-- Name: food food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_pkey PRIMARY KEY (food_id);


--
-- TOC entry 5004 (class 2606 OID 16607)
-- Name: hotel hotel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);


--
-- TOC entry 4982 (class 2606 OID 16488)
-- Name: parent_guardian_view parent_guardian_view_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parent_guardian_view
    ADD CONSTRAINT parent_guardian_view_pkey PRIMARY KEY (guardian_id);


--
-- TOC entry 5000 (class 2606 OID 16581)
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (payment_id);


--
-- TOC entry 4984 (class 2606 OID 16490)
-- Name: silent_support_requests silent_support_requests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.silent_support_requests
    ADD CONSTRAINT silent_support_requests_pkey PRIMARY KEY (request_id);


--
-- TOC entry 4986 (class 2606 OID 16492)
-- Name: special_needs special_needs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.special_needs
    ADD CONSTRAINT special_needs_pkey PRIMARY KEY (need_id);


--
-- TOC entry 5002 (class 2606 OID 16594)
-- Name: transport transport_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transport
    ADD CONSTRAINT transport_pkey PRIMARY KEY (transport_id);


--
-- TOC entry 4988 (class 2606 OID 16494)
-- Name: travel_details travel_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.travel_details
    ADD CONSTRAINT travel_details_pkey PRIMARY KEY (travel_id);


--
-- TOC entry 4990 (class 2606 OID 16496)
-- Name: trip_decision_log trip_decision_log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_decision_log
    ADD CONSTRAINT trip_decision_log_pkey PRIMARY KEY (decision_id);


--
-- TOC entry 5010 (class 2606 OID 16654)
-- Name: trip_withdrawal_request trip_withdrawal_request_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_withdrawal_request
    ADD CONSTRAINT trip_withdrawal_request_pkey PRIMARY KEY (request_id);


--
-- TOC entry 4992 (class 2606 OID 16498)
-- Name: trips trips_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trips
    ADD CONSTRAINT trips_pkey PRIMARY KEY (trip_id);


--
-- TOC entry 4994 (class 2606 OID 16500)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 4996 (class 2606 OID 16502)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 5022 (class 2606 OID 16568)
-- Name: activity activity_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.activity
    ADD CONSTRAINT activity_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id) ON DELETE CASCADE;


--
-- TOC entry 5011 (class 2606 OID 16503)
-- Name: agent_assignment agent_assignment_agent_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agent_assignment
    ADD CONSTRAINT agent_assignment_agent_id_fkey FOREIGN KEY (agent_id) REFERENCES public.agents(agent_id);


--
-- TOC entry 5012 (class 2606 OID 16508)
-- Name: agent_assignment agent_assignment_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agent_assignment
    ADD CONSTRAINT agent_assignment_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id);


--
-- TOC entry 5013 (class 2606 OID 16513)
-- Name: backup_plans backup_plans_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.backup_plans
    ADD CONSTRAINT backup_plans_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id);


--
-- TOC entry 5014 (class 2606 OID 16518)
-- Name: bookings bookings_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id);


--
-- TOC entry 5015 (class 2606 OID 16523)
-- Name: bookings bookings_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 5027 (class 2606 OID 16638)
-- Name: expense expense_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense
    ADD CONSTRAINT expense_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id) ON DELETE CASCADE;


--
-- TOC entry 5026 (class 2606 OID 16621)
-- Name: food food_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id) ON DELETE CASCADE;


--
-- TOC entry 5025 (class 2606 OID 16608)
-- Name: hotel hotel_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id) ON DELETE CASCADE;


--
-- TOC entry 5016 (class 2606 OID 16528)
-- Name: parent_guardian_view parent_guardian_view_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parent_guardian_view
    ADD CONSTRAINT parent_guardian_view_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 5023 (class 2606 OID 16582)
-- Name: payment payment_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id) ON DELETE CASCADE;


--
-- TOC entry 5017 (class 2606 OID 16533)
-- Name: silent_support_requests silent_support_requests_booking_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.silent_support_requests
    ADD CONSTRAINT silent_support_requests_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES public.bookings(booking_id);


--
-- TOC entry 5018 (class 2606 OID 16538)
-- Name: special_needs special_needs_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.special_needs
    ADD CONSTRAINT special_needs_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 5024 (class 2606 OID 16595)
-- Name: transport transport_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transport
    ADD CONSTRAINT transport_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id) ON DELETE CASCADE;


--
-- TOC entry 5019 (class 2606 OID 16543)
-- Name: travel_details travel_details_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.travel_details
    ADD CONSTRAINT travel_details_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id);


--
-- TOC entry 5020 (class 2606 OID 16548)
-- Name: trip_decision_log trip_decision_log_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_decision_log
    ADD CONSTRAINT trip_decision_log_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id);


--
-- TOC entry 5021 (class 2606 OID 16553)
-- Name: trip_decision_log trip_decision_log_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_decision_log
    ADD CONSTRAINT trip_decision_log_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 5028 (class 2606 OID 16655)
-- Name: trip_withdrawal_request trip_withdrawal_request_booking_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_withdrawal_request
    ADD CONSTRAINT trip_withdrawal_request_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES public.bookings(booking_id) ON DELETE CASCADE;


--
-- TOC entry 5029 (class 2606 OID 16665)
-- Name: trip_withdrawal_request trip_withdrawal_request_trip_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_withdrawal_request
    ADD CONSTRAINT trip_withdrawal_request_trip_id_fkey FOREIGN KEY (trip_id) REFERENCES public.trips(trip_id) ON DELETE CASCADE;


--
-- TOC entry 5030 (class 2606 OID 16660)
-- Name: trip_withdrawal_request trip_withdrawal_request_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trip_withdrawal_request
    ADD CONSTRAINT trip_withdrawal_request_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


-- Completed on 2026-03-07 18:19:57

--
-- PostgreSQL database dump complete
--

\unrestrict XOGdKc06cdTWdJAjxaAh1feTrTudi4cu91bIHVlmroY9CePfaNmy73N5V7Fv2h5

