INSERT INTO ITEM (name, category, quantity, action_plan, status, notes, created_at, updated_at) VALUES
('冷蔵庫', '家電', 1, 'TAKE', 'NOT_STARTED', '引越先で使用', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('ベッド', '家具', 1, 'DISCARD', 'IN_PROGRESS', '処分予定', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('延長コード', '雑貨', 2, 'BUY', 'NOT_STARTED', '買い足し', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO TASK (name, deadline, status, notes, created_at, updated_at) VALUES
('引越業者の手配', '2026-02-03', 'NOT_STARTED', '複数社から見積もりを取る', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('会社の住所情報変更（CWSにて変更）', '2026-02-25', 'NOT_STARTED', '', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('住民票の変更手続き', '2026-02-25', 'NOT_STARTED', '役所にて手続き', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);