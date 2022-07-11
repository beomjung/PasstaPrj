# -*- coding:utf-8 -*-
from flask import Flask, request
import cv2
from face_create_image_train import face_train
from face_predict import face_predict
import CmmUtil as cu
from seleniumService import seleniumCrawling
import json

application = Flask(__name__)

@application.route("/")
def hello():
    return "<h1> 파이썬!! </h1>"

# 셀레니움 크롤링
@application.route('/crawlingAPI', methods=['POST', 'GET'])
def crawling():
    print("crawling start!!")
    # 입력받을 문장

    rList = seleniumCrawling()
    print("rList : ", rList)
    print("2")
    div = json.dumps(rList, ensure_ascii=False)
    print("2")
    print("crawling end!!")
    return div

# 얼굴인식 및 페이스 로그인
@application.route('/facedetecting', methods=['POST', 'GET'])
def facedeting():
    print("face detecting start")
    return "face complate"

@application.route("/facelearningAPI", methods=['POST', 'GET'])
def faceLearning():

    contents = request.get_json(force=True,silent=True)
    print("몇개 ? : ", len(contents))
    user_id = str(contents[0])
    res = face_train(user_id, contents)

    return res

@application.route("/faceloginAPI", methods=['POST'])
def faceAnalysis():
    contents = request.get_json(force=True,silent=True)
    print(str(contents[0]))
    user_id = str(contents[0])
    print(len(contents))

    ress = face_predict(user_id, contents)

    return ress

if __name__ == "__main__":
    application.run(host="0.0.0.0", port=8000)