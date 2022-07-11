# -*- coding:utf-8 -*-

from flask import Flask
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options

# create a new chrome session
options = Options()
options.add_argument('--headless')
options.add_argument('--no-sandbox')


def seleniumCrawling():
    # 크롬 Webdriver open
    # driver = webdriver.Chrome(chrome_options=options, executable_path="./chromedriver.exe")
    driver = webdriver.Chrome("./chromedriver.exe")
    driver.implicitly_wait(3)

    siteList = [1, 19, 2, 23, 20]
    # siteList = [1,19]
    areaList = ["기획아이디어", "디자인", "광고/마케팅", "문학/시나리오", "IT/소프트웨어"]
    k = 0
    wList = []

    for i in siteList:
        rList = {}
        driver.implicitly_wait(15)  # 15초 대기
        print("crawling gogo")
        driver.get(f"https://www.wevity.com/?c=find&s=1&gub=1&cidx={i}")
        print("crawling beybey")
        driver.implicitly_wait(15)  # 15초 대기

        list = []
        for j in range(2, 12):
            driver.find_element_by_xpath(f'//*[@id="container"]/div[2]/div[1]/div[2]/div[3]/div/ul/li[{j}]/div[1]/a').click()
            CONTEST_NAME = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[1]/h6').text  # 공모전 이름
            CONTEST_IMG = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div[1]/img').get_attribute('src') # 이미지 주소
            CONTEST_HOST = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[3]').text  # 주최
            CONTEST_AREA = (areaList[k])  # 분야
            CONTEST_DAY = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[5]').text  # 기간
            CONTEST_PRIZE = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[6]').text # 총상금
            CONTEST_ADDR = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[8]/a').get_attribute('href')  # 홈페이지주소
            CONTEST_CONTENTS = driver.find_element_by_css_selector('#viewContents').get_attribute('innerHTML') # 공모전 내용

            ContestDTO = {}  # object
            ContestDTO['contest_name'] = CONTEST_NAME
            ContestDTO['contest_img'] = CONTEST_IMG
            ContestDTO['contest_host'] = CONTEST_HOST
            ContestDTO['contest_area'] = CONTEST_AREA # 분야
            ContestDTO['contest_day'] = CONTEST_DAY
            ContestDTO['contest_prize'] = CONTEST_PRIZE
            ContestDTO['contest_addr'] = CONTEST_ADDR
            ContestDTO['contest_contents'] = CONTEST_CONTENTS

            list.append(ContestDTO)
            # print("CONTEST_NAME : ", CONTEST_NAME)
            # print("CONTEST_IMG : ", CONTEST_IMG)
            # print("CONTEST_HOST : ",CONTEST_HOST)
            # print("CONTEST_AREA : ",CONTEST_AREA)
            # print("CONTEST_DAY : ",CONTEST_DAY)
            # print("CONTEST_PRIZE : ",CONTEST_PRIZE)
            # print("CONTEST_ADDR : ",CONTEST_ADDR)
            # print("CONTEST_CONTENT : ",CONTEST_CONTENTS)

            driver.back()
        rList['rlist'] = list
        wList.append(rList)
        k = k + 1
    print(wList)
    return wList
