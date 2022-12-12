-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2018 at 09:24 AM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `raw_lotto`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_bal`
--

CREATE TABLE IF NOT EXISTS `add_bal` (
  `id` int(11) NOT NULL,
  `usid` varchar(255) NOT NULL,
  `amount` varchar(255) NOT NULL,
  `via` varchar(255) NOT NULL,
  `too` varchar(255) NOT NULL,
  `frm` varchar(255) NOT NULL,
  `trx` varchar(255) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bid_bid`
--

CREATE TABLE IF NOT EXISTS `bid_bid` (
  `id` int(11) NOT NULL,
  `gid` varchar(20) NOT NULL,
  `userid` varchar(20) NOT NULL,
  `winstatus` int(1) NOT NULL DEFAULT '0',
  `bidtm` varchar(25) NOT NULL,
  `tkt` varchar(255) NOT NULL,
  `bidaff` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bid_bid`
--

INSERT INTO `bid_bid` (`id`, `gid`, `userid`, `winstatus`, `bidtm`, `tkt`, `bidaff`) VALUES
(1, '3', '1', 1, '1459582593', '31604028902', '1'),
(2, '3', '1', 0, '1459582598', '31604028296', '1'),
(3, '4', '1', 0, '1459711451', '41604034826', '1'),
(4, '4', '1', 0, '1459713525', '41604033633', '1'),
(5, '4', '1', 0, '1459713528', '41604039480', '1'),
(6, '4', '1', 0, '1459713571', '41604035680', '1'),
(7, '5', '1', 0, '1459713593', '51604031215', '1'),
(8, '4', '1', 0, '1531736864', '41807163031', '1'),
(9, '4', '1', 0, '1531736875', '41807163936', '1'),
(10, '4', '1', 0, '1531736882', '41807167920', '1'),
(11, '4', '1', 0, '1531736884', '41807168501', '1'),
(12, '4', '1', 0, '1531736887', '41807166282', '1'),
(13, '4', '1', 0, '1531736890', '41807161988', '1'),
(14, '4', '1', 0, '1531736893', '41807163849', '1'),
(15, '4', '1', 0, '1531736895', '41807169955', '1'),
(16, '4', '1', 0, '1531736898', '41807162695', '1'),
(17, '4', '1', 0, '1531736900', '41807165929', '1'),
(18, '4', '1', 0, '1531736902', '41807167988', '1'),
(19, '4', '1', 0, '1531736903', '41807168156', '1');

-- --------------------------------------------------------

--
-- Table structure for table `club`
--

CREATE TABLE IF NOT EXISTS `club` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `club`
--

INSERT INTO `club` (`id`, `title`, `img`) VALUES
(6, 'King Club ( Starts From $10 )', '1459710882.png'),
(5, 'Royal Club ( Starts From $1 )', '1459710853.jpg'),
(7, 'Evilz Club ( Starts From $100)', '1459710894.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `deposit_data`
--

CREATE TABLE IF NOT EXISTS `deposit_data` (
  `id` int(11) NOT NULL,
  `usid` int(11) DEFAULT NULL,
  `tm` varchar(255) DEFAULT NULL,
  `method` int(11) DEFAULT NULL,
  `track` varchar(255) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `charge` varchar(255) DEFAULT NULL,
  `amountus` varchar(255) DEFAULT NULL,
  `bcam` varchar(255) DEFAULT '0',
  `bcid` varchar(255) DEFAULT '0',
  `trx` varchar(255) DEFAULT NULL,
  `trx_ext` varchar(255) DEFAULT NULL,
  `try` int(11) NOT NULL DEFAULT '0',
  `status` int(1) DEFAULT '0'
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deposit_data`
--

INSERT INTO `deposit_data` (`id`, `usid`, `tm`, `method`, `track`, `amount`, `charge`, `amountus`, `bcam`, `bcid`, `trx`, `trx_ext`, `try`, `status`) VALUES
(1, 1, '1531736297', 1, '99f7d3c3935ce4f98c6cb0346314dd60', '100', '3.3', '103.3', '0', '0', NULL, NULL, 0, 0),
(2, 1, '1531736355', 2, 'b262e8f7f8ededc8ae3cef2a3dc42758', '100', '3', '103', '0', '0', NULL, NULL, 0, 0),
(3, 1, '1531736379', 2, 'f72a26c94c1574748a09dd008d87e2a0', '100', '3', '103', '0', '0', NULL, NULL, 0, 0),
(4, 1, '1531736409', 2, '406b9d3a7bcc1768bb4ec6e635e2296d', '100', '3', '103', '0', '0', NULL, NULL, 0, 0),
(5, 1, '1531736436', 2, '1e75a9a9e50a05703263571793e14fa7', '100', '3', '103', '0', '0', NULL, NULL, 0, 0),
(6, 1, '1531736500', 3, '97f939711b96f8d41291ac947bbf8848', '100', '1.5', '101.5', '0.01554296', '', NULL, NULL, 0, 0),
(7, 1, '1531736563', 3, '33b4f94b7e7ace704d3c6e322dec19ec', '100', '1.5', '101.5', '0.01554726', '', NULL, NULL, 0, 0),
(8, 1, '1531736581', 4, 'c1e7886acee21909f65188d509971d11', '100', '6', '106', '0', '0', NULL, NULL, 0, 0),
(9, 1, '1531736642', 4, '483d224dac407a33fc54dd9b555d3bbe', '100', '6', '106', '0', '0', NULL, NULL, 0, 0),
(10, 1, '1531736944', 5, '955147fd51e9aff962569f862907a382', '100', '2', '102', '0', '0', NULL, NULL, 0, 0),
(11, 1, '1531736967', 6, '4aaa99f4f3479139d458398411667d02', '100', '2', '102', '0', '0', NULL, NULL, 0, 0),
(12, 1, '1531737052', 7, 'a7b7287e4daeb4fc345237986362ecb8', '100', '1.5', '101.5', '0.01553515', '0', NULL, NULL, 0, 0),
(13, 1, '1531737067', 8, 'a84eb9e3b106c74c7eb44d235de6df77', '100', '2', '102', '0.0156129', '3HEdMUz9DZH1CYSrdGBtdWp9XKxH92psKS', NULL, NULL, 0, 0),
(14, 1, '1531737095', 503, 'b5275ebf0b781ab9cbf392de2a588fa7', '100', '2', '102', '1.24490747', '3EJNU6YDk3Gtcdb7UEHMdxkRM1E5vZZZPa', NULL, NULL, 0, 0),
(15, 1, '1531737110', 504, 'a9069c90f627d77d20e66c58d4359416', '100', '2', '102', '41189.98679497', 'ACajVbD2qW6mszJPFHj5fdrJdtDaAxeRHa', NULL, NULL, 0, 0),
(16, 1, '1531737129', 505, 'c60bb5f73c2cf80a96f966deba2f3b2c', '100', '2', '102', '0.01564752', '3MQoLnLfu1V1d6ib3wtS8LMHmdGkQzwM6Y', NULL, NULL, 0, 0),
(17, 1, '1531737150', 506, 'e4d36b97de1a23ce0be170f6b2728c9f', '100', '1.5', '101.5', '0.21782077', '0x3ff14a1edad55a0d18b3d678ac774bba23863e17', NULL, NULL, 0, 0),
(18, 1, '1531737165', 507, '0da2cba96d5a399bd541b4cfda45a977', '100', '2', '102', '0.13460698', '1ByLfaEvon1GvcTjLbN5kGjgNwScSeuaxP', NULL, NULL, 0, 0),
(19, 1, '1531737177', 508, '11135356d33210035070975376906a85', '100', '2', '102', '0.43223124', 'XoX9qzNen7Q7ou8aa22x3Py1wauDVSohCj', NULL, NULL, 0, 0),
(20, 1, '1531737191', 509, '41ba02a160da9005aa9c4229063be5ad', '100', '2', '102', '40819.62573658', 'DAkKjb2tGk4orj2VebkKW9nFVREQ5s872j', NULL, NULL, 0, 0),
(21, 1, '1531737221', 510, '8df3d37c10c5f971fd4989b3a681e946', '100', '2', '102', '1.25112125', 'Lhv1ciEtwTwkaHDXYLBMNQ5ew2dxhQ3X8f', NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `deposit_method`
--

CREATE TABLE IF NOT EXISTS `deposit_method` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `minamo` varchar(255) DEFAULT NULL,
  `maxamo` varchar(255) DEFAULT NULL,
  `charged` varchar(255) DEFAULT NULL,
  `chargep` varchar(255) DEFAULT NULL,
  `rate` varchar(255) DEFAULT NULL,
  `val1` varchar(255) DEFAULT NULL,
  `val2` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=511 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deposit_method`
--

INSERT INTO `deposit_method` (`id`, `name`, `minamo`, `maxamo`, `charged`, `chargep`, `rate`, `val1`, `val2`, `status`) VALUES
(1, 'Paypal', '10', '1000', '0.3', '3', '1', 'rexrifat636@gmail.com', '', 1),
(2, 'Perfect Money', '20', '20000', '2', '1', '1', 'U55151515', 'reg4e54h1grt1j', 1),
(3, 'Blockchain', '10', '20000', '1', '0.5', '1', 'API2', 'XPUB1', 1),
(4, 'Credit Card', '10', '50000', '3', '3', '1', 'sk_test_aat3tzBCCXXBkS4sxY3M8A1B', 'pk_test_AU3G7doZ1sbdpJLj0NaozPBu', 1),
(5, 'Skrill', '1', '100', '1', '1', '1', 'support@globeskill.com', 'jabali2006', 1),
(6, 'Coingate', '1', '2432141', '1', '1', '1', 'Ba1VgPx6d437xLXGKCBkmwVCEw5kHzRJ6thbGo-N', NULL, 1),
(7, 'CoinPayments', '10', '100', '1', '0.5', '1', 'db1d9f12444e65c921604e289a281c56', 'ABIR', 1),
(8, 'block.io - BTC', '1', '100000', '1', '1', '1', 'a528-2410-1296-395a', '09876softk', 1),
(503, 'BLOCK.IO - LTC', '1', '100000', '1', '1', '1', '4494-4014-373a-3454', '09876softk', 1),
(504, 'BLOCK.IO - DOGE', '1', '1111111', '1', '1', '1', 'b224-398b-8054-8325', '09876softk', 1),
(505, 'CoinPayment - BTC', '1', '11111111', '1', '1', '1', '596f0097ed9d1ab8cfed05eb59c70e9f066513dfe4df64a8fc3917d309328315', '7472928395208f70E3cE30B9e10dc882cBDD3e9967b7942AaE492106d9C7bE44', 1),
(506, 'CoinPayment - ETH', '1', '1111111', '1', '0.5', '1', '596f0097ed9d1ab8cfed05eb59c70e9f066513dfe4df64a8fc3917d309328315', '7472928395208f70E3cE30B9e10dc882cBDD3e9967b7942AaE492106d9C7bE44', 1),
(507, 'CoinPayment - BCH', '1', '11111', '1', '1', '1', '596f0097ed9d1ab8cfed05eb59c70e9f066513dfe4df64a8fc3917d309328315', '7472928395208f70E3cE30B9e10dc882cBDD3e9967b7942AaE492106d9C7bE44', 1),
(508, 'CoinPayment - DASH', '1', '111111', '1', '1', '1', '596f0097ed9d1ab8cfed05eb59c70e9f066513dfe4df64a8fc3917d309328315', '7472928395208f70E3cE30B9e10dc882cBDD3e9967b7942AaE492106d9C7bE44', 1),
(509, 'CoinPayment - DOGE', '1', '111111', '1', '1', '1', '596f0097ed9d1ab8cfed05eb59c70e9f066513dfe4df64a8fc3917d309328315', '7472928395208f70E3cE30B9e10dc882cBDD3e9967b7942AaE492106d9C7bE44', 1),
(510, 'CoinPayment - LTC', '1', '11111', '1', '1', '1', '596f0097ed9d1ab8cfed05eb59c70e9f066513dfe4df64a8fc3917d309328315', '7472928395208f70E3cE30B9e10dc882cBDD3e9967b7942AaE492106d9C7bE44', 1);

-- --------------------------------------------------------

--
-- Table structure for table `general_setting`
--

CREATE TABLE IF NOT EXISTS `general_setting` (
  `id` int(11) NOT NULL,
  `sitename` varchar(255) DEFAULT NULL,
  `txt1` blob,
  `txt2` blob
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `general_setting`
--

INSERT INTO `general_setting` (`id`, `sitename`, `txt1`, `txt2`) VALUES
(1, 'Lets-Lotto', 0x57454c434f4d4520544f204c4554534c4f54544f20212120504c41592046554e204541524e, 0x4c6f7474657279206973206f6e65206f6620746865206d6f737420706f70756c617220666f726d73206f662067616d626c696e6720696e2074686520776f726c642c20616e6420696e20736f6d6520636f756e7472696573206f6e6c696e65206c6f7474657279206973206d6f726520706f70756c6172207468616e206f6e6c696e6520636173696e6f2067616d65732e);

-- --------------------------------------------------------

--
-- Table structure for table `head_tail`
--

CREATE TABLE IF NOT EXISTS `head_tail` (
  `id` int(11) NOT NULL,
  `userid` varchar(20) NOT NULL,
  `bidon` varchar(20) NOT NULL,
  `amount` varchar(20) NOT NULL,
  `winstat` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `home_txt`
--

CREATE TABLE IF NOT EXISTS `home_txt` (
  `id` int(11) NOT NULL,
  `h` varchar(255) DEFAULT NULL,
  `sh` varchar(255) DEFAULT NULL,
  `dt` blob
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `home_txt`
--

INSERT INTO `home_txt` (`id`, `h`, `sh`, `dt`) VALUES
(1, 'ONLINE LOTTO', 'Instant Online Lotto.', 0x4c6f7474657279206973206f6e65206f6620746865206d6f737420706f70756c617220666f726d73206f662067616d626c696e6720696e2074686520776f726c642c20616e6420696e20736f6d6520636f756e7472696573206f6e6c696e65206c6f7474657279206973206d6f726520706f70756c6172207468616e206f6e6c696e6520636173696e6f2067616d65732e),
(2, 'RAFFLE DRAW', 'Raffle Draw Club', 0x4c6f7474657279206973206f6e65206f6620746865206d6f737420706f70756c617220666f726d73206f662067616d626c696e6720696e2074686520776f726c642c20616e6420696e20736f6d6520636f756e7472696573206f6e6c696e65206c6f7474657279206973206d6f726520706f70756c6172207468616e206f6e6c696e6520636173696e6f2067616d65732e),
(3, 'INSTANT LOTTERY', 'Multiple Club Lottery And More..', 0x4c6f7474657279206973206f6e65206f6620746865206d6f737420706f70756c617220666f726d73206f662067616d626c696e6720696e2074686520776f726c642c20616e6420696e20736f6d6520636f756e7472696573206f6e6c696e65206c6f7474657279206973206d6f726520706f70756c6172207468616e206f6e6c696e6520636173696e6f2067616d65732e);

-- --------------------------------------------------------

--
-- Table structure for table `lotto_game`
--

CREATE TABLE IF NOT EXISTS `lotto_game` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `btext` blob NOT NULL,
  `club` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL DEFAULT '0',
  `prize` varchar(255) NOT NULL DEFAULT '0',
  `status` varchar(1) NOT NULL DEFAULT '0',
  `winop` varchar(255) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lotto_game`
--

INSERT INTO `lotto_game` (`id`, `title`, `btext`, `club`, `price`, `prize`, `status`, `winop`) VALUES
(1, 'Today Draw', 0x6862637472676274726e6272746e62686a, '1', '10', '100', '1', ''),
(2, 'Today Draw', 0x6862637472676274726e6272746e62686a, '1', '10', '100', '1', ''),
(3, 'leja leja', 0x6b6f70612073616d7375206b6f7061, '1', '1', '2', '1', ''),
(4, 'Royal HIPI Lotto', 0x526f79616c2048495049204c6f74746f2052756e696e672c204c6574732042757920796f7572207469636b65742c2077696e6e65722077696c6c20676f7420313024, '5', '1', '10', '0', ''),
(5, 'Kings Flaver Lottery', 0x4b696e677320466c61766572204c6f74746572792077696e6e65722077696c6c207265636569766520313030242e20, '6', '10', '100', '0', ''),
(6, 'Evu Raffle Draw', 0x446f6e74206d69737320746865206368616e6765206f662077696e2031303030242e2e2042757920796f757220726166666c65207469636b6574206e6f77, '7', '100', '1000', '0', '');

-- --------------------------------------------------------

--
-- Table structure for table `seventrade_bid`
--

CREATE TABLE IF NOT EXISTS `seventrade_bid` (
  `id` int(11) NOT NULL,
  `gid` varchar(20) NOT NULL,
  `userid` varchar(20) NOT NULL,
  `ballid` varchar(20) NOT NULL,
  `winstatus` int(1) NOT NULL DEFAULT '0',
  `bidtm` varchar(25) NOT NULL,
  `rewin` int(1) NOT NULL DEFAULT '0',
  `gstat` int(1) NOT NULL DEFAULT '0',
  `bidaff` int(1) NOT NULL DEFAULT '0',
  `winaff` int(1) NOT NULL DEFAULT '0',
  `rtime` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seventrade_game`
--

CREATE TABLE IF NOT EXISTS `seventrade_game` (
  `id` int(11) NOT NULL,
  `gid` varchar(20) NOT NULL,
  `shuru` varchar(20) NOT NULL,
  `sesh` varchar(20) NOT NULL,
  `status` int(1) NOT NULL,
  `winball` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `slider_home`
--

CREATE TABLE IF NOT EXISTS `slider_home` (
  `id` int(11) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `btxt` varchar(255) DEFAULT NULL,
  `stxt` varchar(255) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `slider_home`
--

INSERT INTO `slider_home` (`id`, `img`, `btxt`, `stxt`) VALUES
(10, '1499194651.jpg', 'BEST ONLINE LOTTERY HERE', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium sint delectus numquam deserunt corrupti consectetur asperiores iusto saepe dolores ut.'),
(9, '1499194614.jpg', 'LIVE ONLINE LOTTERY GAME', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium sint delectus numquam deserunt corrupti consectetur asperiores iusto saepe dolores ut.');

-- --------------------------------------------------------

--
-- Table structure for table `trx_history`
--

CREATE TABLE IF NOT EXISTS `trx_history` (
  `id` int(11) NOT NULL,
  `usid` varchar(255) NOT NULL,
  `des` varchar(255) NOT NULL,
  `sig` varchar(255) NOT NULL,
  `amount` varchar(255) NOT NULL,
  `tm` varchar(255) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trx_history`
--

INSERT INTO `trx_history` (`id`, `usid`, `des`, `sig`, `amount`, `tm`) VALUES
(1, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736864'),
(2, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736864'),
(3, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736875'),
(4, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736875'),
(5, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736882'),
(6, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736882'),
(7, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736884'),
(8, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736884'),
(9, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736887'),
(10, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736887'),
(11, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736890'),
(12, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736890'),
(13, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736893'),
(14, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736893'),
(15, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736895'),
(16, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736895'),
(17, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736898'),
(18, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736898'),
(19, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736900'),
(20, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736900'),
(21, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736902'),
(22, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736902'),
(23, '1', 'Buy Ticket On Royal HIPI Lotto', '-', '1', '1531736903'),
(24, '1', 'Affiliate Bonus from admin for Bid On Royal HIPI Lotto', '+', '1', '1531736903');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `ref` int(11) NOT NULL DEFAULT '1',
  `mallu` varchar(20) NOT NULL DEFAULT '0',
  `sid` varchar(255) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `fullname`, `password`, `email`, `phone`, `country`, `ref`, `mallu`, `sid`) VALUES
(1, 'admin', '', '21232f297a57a5a743894a0e4a801fc3', '', '', '', 1, '857', '7c0abf5d89dd987ead63d62fcb2d4aeb'),
(2, 'controller', '', '21232f297a57a5a743894a0e4a801fc3', '', '', '', 1, '0', '87bdbfe868488643d95c68d843f7965f'),
(3, 'ccccxxxx', '', 'b4857964251468ce19de255a1d6cd8b3', 'ccccxxxx@ccccxxxx.com', '0018765851111', 'Bangladesh', 1, '0', '9f7f0861b91c43a6038d026ea2732d13'),
(4, 'akhanana', '', '7c14ce9a1e78b5a0ba0a48129001095b', 'akhanana@akhanana.akhanana', '8801671545690', 'Bangladesh', 1, '0', ''),
(5, 'abababaab', '', '70d2e693b3f41e728a726e8d1730b02c', 'abababaab@abababaab.abababaab', '880115599', 'Bangladesh', 1, '0', ''),
(6, 'picci', '', '348b4d4b707dd686b1d96d48549293a0', 'admin@thesoftking.com', '18801912751111', 'USA', 1, '0', ''),
(7, 'abirkhan75', '', 'c3c21805b342901ec009ca995efaae16', 'abirkhaan75@gmail.com', 'abirkhan75', 'Bangladesh', 1, '500', '66cdf6f73c6e50acb67957d663d8f8bb');

-- --------------------------------------------------------

--
-- Table structure for table `wd_bal`
--

CREATE TABLE IF NOT EXISTS `wd_bal` (
  `id` int(11) NOT NULL,
  `usid` varchar(255) NOT NULL,
  `amount` varchar(255) NOT NULL,
  `via` varchar(255) NOT NULL,
  `too` varchar(255) NOT NULL,
  `frm` varchar(255) NOT NULL,
  `trx` varchar(255) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_bal`
--
ALTER TABLE `add_bal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bid_bid`
--
ALTER TABLE `bid_bid`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deposit_data`
--
ALTER TABLE `deposit_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deposit_method`
--
ALTER TABLE `deposit_method`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `general_setting`
--
ALTER TABLE `general_setting`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `head_tail`
--
ALTER TABLE `head_tail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `home_txt`
--
ALTER TABLE `home_txt`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lotto_game`
--
ALTER TABLE `lotto_game`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seventrade_bid`
--
ALTER TABLE `seventrade_bid`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seventrade_game`
--
ALTER TABLE `seventrade_game`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `gid` (`gid`);

--
-- Indexes for table `slider_home`
--
ALTER TABLE `slider_home`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trx_history`
--
ALTER TABLE `trx_history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `wd_bal`
--
ALTER TABLE `wd_bal`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `add_bal`
--
ALTER TABLE `add_bal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `bid_bid`
--
ALTER TABLE `bid_bid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `club`
--
ALTER TABLE `club`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `deposit_data`
--
ALTER TABLE `deposit_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `deposit_method`
--
ALTER TABLE `deposit_method`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=511;
--
-- AUTO_INCREMENT for table `general_setting`
--
ALTER TABLE `general_setting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `head_tail`
--
ALTER TABLE `head_tail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `home_txt`
--
ALTER TABLE `home_txt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `lotto_game`
--
ALTER TABLE `lotto_game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `seventrade_bid`
--
ALTER TABLE `seventrade_bid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `seventrade_game`
--
ALTER TABLE `seventrade_game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `slider_home`
--
ALTER TABLE `slider_home`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `trx_history`
--
ALTER TABLE `trx_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `wd_bal`
--
ALTER TABLE `wd_bal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
