Simport pathlib
import base64
from io import BytesIO

import cv2
import numpy as np
from PIL import Image

def face_train(user_id, contents):

    try:
        # 하르분류기 로드
        face_cascade = cv2.CascadeClassifier("./data/haarcascade_frontalface_alt2.xml")

        # LBPH 알고리즘 선언
        model = cv2.face.LBPHFaceRecognizer_create()

        # 학습할 데이터구조 선언(학습데이터, 라벨링)
        training_data, labels = [], []
        count = 0

        # 학습시킬 이미지 파일 경로
        data_dir = pathlib.Path("/faceimg/"+user_id)
        print("data_dir : ", data_dir)
        
        # 학습데이터 수 출력하기
        image_count = len(list(data_dir.glob("*.jpeg")))
        print("image_count : ", image_count)

        # 얼굴 이미지 수만큼 학습하기 위해 반복하기
        for i in range(1, len(contents)):

            # 폴더 내 이미지 모두 가져와서 학습시키기
            # my_image = cv2.imread(str(image_path), cv2.IMREAD_COLOR)
            img = np.array(Image.open(BytesIO(base64.b64decode(contents[i]))))

            # 카메라의 프레임을 얼굴인식율을 높이기 위해 흑백으로 변경함
            gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

            # 변환된 흑백사진으로부터 히스토그램 평활화
            gray = cv2.equalizeHist(gray)

            # 얼굴 인식하기
            faces = face_cascade.detectMultiScale(gray, 1.1, 5, 0, (20, 20))

            # 인식된 얼굴의 수
            facesCnt = len(faces)

            if facesCnt == 1:
                count += 1

                x, y, w, h = faces[0]

                face_image = gray[y:y + h, x:x + w]

                training_data.append(face_image)
                labels.append(count)

        print("labels : ", labels)
        model.train(training_data, np.array(labels))
        print("./model/" + user_id + "_trainner.yml")
        model.save("./model/"+user_id+"_trainner.yml")
        res = "success"
    except:
        print("error!! image_train fail")
        res = "fail"
    return res