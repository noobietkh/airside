package com.ncs.airside.controller;

import com.syc.function.Function.RFID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RFIDController {

    private Logger logger = LoggerFactory.getLogger(RFIDController.class);

    @GetMapping("/rfidopen")
    public ResponseEntity rficOpen() {

        if(RFID.instance.CFHid_GetUsbCount() > 0)
        {
            if(RFID.instance.CFHid_OpenDevice(0))
            {
                logger.info("Success\r\n");
                byte[] arrBuffer = new byte[48];
                byte addr = (byte)0xff;
                if(RFID.instance.CFHid_GetDeviceSystemInfo(addr, arrBuffer))  //Get DeviceInfo
                {
                    String str = "",str1="";
                    str = String.format("SoftVer:%d.%d\r\n", arrBuffer[0] >> 4, arrBuffer[0] & 0x0F);
                    logger.info(str);
                    str = String.format("HardVer:%d.%d\r\n", arrBuffer[1] >> 4, arrBuffer[1] & 0x0F);
                    logger.info(str);
                    str = "SN:";
                    for (int i = 0; i < 7; i++)
                    {
                        str1 = String.format("%02X", arrBuffer[2 + i]);
                        str = str + str1;
                    }
                    str = str + "\r\n";
                    logger.info(str);

                    RFID.instance.CFHid_ClearTagBuf();
                    return new ResponseEntity(HttpStatus.OK);
                }
                else logger.error("Failed");
                return ResponseEntity.badRequest().body("Unable to get device system Info");
            }
        }
        else logger.error("Failed");
        return ResponseEntity.badRequest().body("CFHid_GetUsbCount is not more than 0");
    }

    @GetMapping("/rfidclose")
    public ResponseEntity rficClose() {
        RFID.instance.CFHid_CloseDevice();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rfidread")
    public ResponseEntity rfidRead() {

       byte bParamAddr = 0;
        byte[] bValue = new byte[2];

	            /*  01: Transport
	                02: WorkMode
	                03: DeviceAddr
	                04: FilterTime
	                05: RFPower
	                06: BeepEnable
	                07: UartBaudRate*/
        bParamAddr = (byte)0x05;

        if (RFID.instance.CFHid_ReadDeviceOneParam((byte)0xFF, bParamAddr, bValue) == false)
        {
            logger.error("Failed");
            return ResponseEntity.badRequest().body("CFHid_ReadDeviceOneParam return false");
        }
        logger.info("Success");
        return ResponseEntity.ok().header("RFPower", "0").build();
    }

    @GetMapping("/rfidset")
    public ResponseEntity rfidSet() {

        byte bParamAddr = 0;
        byte[] bValue = new byte[2];

	            /*  01: Transport
	                02: WorkMode
	                03: DeviceAddr
	                04: FilterTime
	                05: RFPower
	                06: BeepEnable
	                07: UartBaudRate*/
        bParamAddr = (byte)0x05;

        if (RFID.instance.CFHid_ReadDeviceOneParam((byte)0xFF, bParamAddr, bValue) == false)
        {
            logger.error("Failed");
            return ResponseEntity.badRequest().body("CFHid_ReadDeviceOneParam return false");
        }
        logger.info("Success");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rfidread_1")
    public ResponseEntity rfidRead_1() {

        byte[] pFreq = new byte[2];
        if (RFID.instance.CFHid_ReadFreq((byte)0xFF, pFreq) == false)
        {
            logger.error("Failed");
            return ResponseEntity.badRequest().body("CFHid_ReadFreq return false");
        }
        //pFreq[0]   pFreq[1]
        //0x31        0x80     //US Freq
        //0x4E        0x00     //Europe
        //0x2C        0xA3     //China
        //0x29        0x9D     //Korea
        //0x2E        0x9F     //Australia
        //0x4E        0x00     //New Zealand
        //0x4E        0x00     //India
        //0x2C        0x81     //Singapore
        //0x2C        0xA3     //Hongkong
        //0x31        0xA7     //Taiwan
        //0x31        0x80     //Canada
        //0x31        0x80     //Mexico
        //0x31        0x99     //Brazil
        //0x1C        0x99     //Israel
        //0x24        0x9D     //South Africa
        //0x2C        0xA3     //Thailand
        //0x28        0xA1     //Malaysia
        //0x29        0x9D     //Japan

        logger.info("Success\r\n");
        if(pFreq[0] == 0x31 && pFreq[1] == 0x80)
            return ResponseEntity.ok().header("Frequency", "US").build();
        else if(pFreq[0] == 0x4E && pFreq[1] == 0x00)
            return ResponseEntity.ok().header("Frequency", "Europe").build();
        else if(pFreq[0] == 0x2C && pFreq[1] == 0xA3)
            return ResponseEntity.ok().header("Frequency", "China").build();
        else if(pFreq[0] == 0x29 && pFreq[1] == 0x9D)
            return ResponseEntity.ok().header("Frequency", "Korea").build();
        else if(pFreq[0] == 0x2E && pFreq[1] == 0x9F)
            return ResponseEntity.ok().header("Frequency", "Australia").build();
        else
            return ResponseEntity.ok().header("Frequency", "US").build();
    }

    @GetMapping("/rfidset_1/{freqIndex}")
    public ResponseEntity rfidSet_1(@PathVariable int freqIndex) {

        byte[] pFreq = new byte[2];
        byte bSelect = 0;
        bSelect =  (byte) freqIndex;
        //pFreq[0]   pFreq[1]
        //0x31        0x80     //US Freq
        //0x4E        0x00     //Europe
        //0x2C        0xA3     //China
        //0x29        0x9D     //Korea
        //0x2E        0x9F     //Australia
        //0x4E        0x00     //New Zealand
        //0x4E        0x00     //India
        //0x2C        0x81     //Singapore
        //0x2C        0xA3     //Hongkong
        //0x31        0xA7     //Taiwan
        //0x31        0x80     //Canada
        //0x31        0x80     //Mexico
        //0x31        0x99     //Brazil
        //0x1C        0x99     //Israel
        //0x24        0x9D     //South Africa
        //0x2C        0xA3     //Thailand
        //0x28        0xA1     //Malaysia
        //0x29        0x9D     //Japan
        if(bSelect == 0) {pFreq[0] = (byte)0x31;pFreq[1] = (byte)0x80;}
        else if(bSelect == 1) {pFreq[0] = (byte)0x4E;pFreq[1] = (byte)0x00;}
        else if(bSelect == 2) {pFreq[0] = (byte)0x2C;pFreq[1] = (byte)0xA3;}
        else if(bSelect == 3) {pFreq[0] = (byte)0x29;pFreq[1] = (byte)0x9D;}
        else if(bSelect == 4) {pFreq[0] = (byte)0x2E;pFreq[1] = (byte)0x9F;}

        if (RFID.instance.CFHid_SetFreq((byte)0xFF, pFreq) == false)
        {
            logger.error("Failed");
            return ResponseEntity.badRequest().body("CFHid_SetFreq return false");
        }
        logger.info("Success");
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/rfidread_1_1")
    public ResponseEntity rfidRead_1_1() {

        if (RFID.instance.CFHid_StartRead((byte)0xFF) == false)
        {
            logger.error("Failed");
            return ResponseEntity.badRequest().body("CFHid_StartRead return false");
        }
        logger.info("Success");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rfidset_1_1")
    public ResponseEntity rfidSet_1_1() {

        if (RFID.instance.CFHid_StopRead((byte)0xFF) == false)
        {
            logger.error("Failed");
            return ResponseEntity.badRequest().body("CFHid_StopRead return false");
        }
        logger.info("Success");
        return ResponseEntity.ok().build();
    }

}
